package me.cameronwhyte.mods.aestheticnether.common.world.features.structure;

import com.mojang.datafixers.Dynamic;
import me.cameronwhyte.mods.aestheticnether.AestheticNether;
import me.cameronwhyte.mods.aestheticnether.common.world.template.CompiledTemplate;
import me.cameronwhyte.mods.aestheticnether.common.world.template.RotatedSettingConfigurator;
import me.cameronwhyte.mods.aestheticnether.common.world.template.TemplateCompiler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;

import java.util.Random;
import java.util.function.Function;

public class BloodwoodTreeStructure extends Feature<NoFeatureConfig> {

    protected static final ResourceLocation[] TEMPLATE = new ResourceLocation[] {
            new ResourceLocation(AestheticNether.MODID, "bloodwood_tree")
    };

    private TemplateCompiler templateCompiler;

    public BloodwoodTreeStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> deserialize) {
        super(deserialize);
    }

    @Override
    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        if(!worldIn.isAirBlock(pos)) {
            return false;
        }

        Block up = worldIn.getBlockState(pos.up(1)).getBlock();
        Block down = worldIn.getBlockState(pos.down(1)).getBlock();
        Block north = worldIn.getBlockState(pos.north(1)).getBlock();
        Block south = worldIn.getBlockState(pos.south(1)).getBlock();
        Block east = worldIn.getBlockState(pos.east(1)).getBlock();
        Block west = worldIn.getBlockState(pos.west(1)).getBlock();

        if(up.equals(Blocks.NETHERRACK) && down.equals(Blocks.AIR) && north.equals(Blocks.AIR) && south.equals(Blocks.AIR) && east.equals(Blocks.AIR) && west.equals(Blocks.AIR)) {

            if (this.templateCompiler == null) {
                this.templateCompiler = this.buildCompiler();
            }

            CompiledTemplate template = this.templateCompiler.compile(worldIn, rand, pos.down(7));
            template.addTo(worldIn, rand, 2 | 16);

            return true;
        }

        return false;
    }

    protected TemplateCompiler buildCompiler() {
        return TemplateCompiler.of(TEMPLATE)
                .withSettingConfigurator(RotatedSettingConfigurator.INSTANCE)
                .withProcessor(this::processState);
    }

    protected Template.BlockInfo processState(IWorldReader world, BlockPos origin, Template.BlockInfo srcInfo, Template.BlockInfo info, PlacementSettings settings) {
        BlockState state = info.state;
        Block block = state.getBlock();
        return block == Blocks.STRUCTURE_BLOCK || block == Blocks.AIR ? null : info;
    }
}
