package me.cameronwhyte.mods.aestheticnether.common.objects.entities;

import me.cameronwhyte.mods.aestheticnether.AestheticNether;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class BabyHeatscarSpider extends SpiderEntity {

    //public static final ResourceLocation LOOT_TABLE = new ResourceLocation(AestheticNether.MODID, "loot_tables/entities/heatscarspider");

    private BabyHeatscarSpider(World world) {
        super((EntityType<? extends SpiderEntity>) ANEntities.BABY_HEATSCAR_SPIDER, world);
    }

    public BabyHeatscarSpider(EntityType<? extends SpiderEntity> type, World world) {
        super((EntityType<? extends SpiderEntity>) ANEntities.BABY_HEATSCAR_SPIDER, world);
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.5F;
    }

    //@Override
    //protected ResourceLocation getLootTable()
    //{
        //return LOOT_TABLE;
    //}

    @Override
    public void jump()
    {
        this.setMotion(this.getMotion().x, .62D, this.getMotion().z);

        if (this.isPotionActive(Effects.JUMP_BOOST))
        {
            this.setMotion(this.getMotion().x, this.getMotion().y+(this.getActivePotionEffect(Effects.JUMP_BOOST).getAmplifier() + 1) * 0.1F, this.getMotion().z);
        }

        if (this.isSprinting())
        {
            float f = this.rotationYaw * 0.017453292F;
            this.setMotion(this.getMotion().x-(MathHelper.sin(f)*.2f), this.getMotion().y, this.getMotion().z+(MathHelper.cos(f)*.2f));
        }

        this.isAirBorne = true;
        ForgeHooks.onLivingJump(this);
    }

    @Override
    public void fall(float distance, float damageMultiplier)
    {
        float[] ret = ForgeHooks.onLivingFall(this, distance, damageMultiplier);
        if (ret == null)
        {
            return;
        }

        super.fall(distance, damageMultiplier);
        int i = MathHelper.ceil(distance - 5.0F);

        if (i > 0)
        {
            if (i > 4)
            {
                this.playSound(SoundEvents.ENTITY_GENERIC_BIG_FALL, 1.0F, 1.0F);
            }
            else
            {
                this.playSound(SoundEvents.ENTITY_GENERIC_SMALL_FALL, 1.0F, 1.0F);
            }

            this.attackEntityFrom(DamageSource.FALL, i);

            BlockPos pos = new BlockPos(MathHelper.floor(this.posX), MathHelper.floor(this.posY - 0.20000000298023224D), MathHelper.floor(this.posZ));
            BlockState state = this.world.getBlockState(pos);
            Block block = state.getBlock();

            if (block != null)
            {
                SoundType stepsound = block.getSoundType(state, this.world, pos, this);
                this.playSound(stepsound.getStepSound(), stepsound.getVolume() * 0.5F, stepsound.getPitch() * 0.75F);
            }
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity par1Entity)
    {
        if (super.attackEntityAsMob(par1Entity))
        {
            if (par1Entity instanceof LivingEntity)
            {
                byte time = 0;

                if (this.world.getDifficulty() != Difficulty.PEACEFUL)
                {
                    if (this.world.getDifficulty() == Difficulty.NORMAL)
                    {
                        time = 5;
                    }
                    else if (this.world.getDifficulty() == Difficulty.HARD)
                    {
                        time = 10;
                    }
                }

                if (time > 0)
                {
                    par1Entity.setFire(time);
                }
            }

            return true;
        }
        else
        {
            return false;
        }
    }

}
