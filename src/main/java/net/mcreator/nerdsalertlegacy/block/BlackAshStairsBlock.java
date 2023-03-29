
package net.mcreator.nerdsalertlegacy.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.nerdsalertlegacy.itemgroup.BlackAshItemGroup;
import net.mcreator.nerdsalertlegacy.NerdsalertLegacyModElements;

import java.util.List;
import java.util.Collections;

@NerdsalertLegacyModElements.ModElement.Tag
public class BlackAshStairsBlock extends NerdsalertLegacyModElements.ModElement {
	@ObjectHolder("nerdsalert_legacy:black_ash_stairs")
	public static final Block block = null;

	public BlackAshStairsBlock(NerdsalertLegacyModElements instance) {
		super(instance, 195);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(BlackAshItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends StairsBlock {
		public CustomBlock() {
			super(() -> new Block(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(3f, 2f).setLightLevel(s -> 0)
					.harvestLevel(0).harvestTool(ToolType.AXE)).getDefaultState(),
					Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(3f, 2f).setLightLevel(s -> 0).harvestLevel(0)
							.harvestTool(ToolType.AXE));
			setRegistryName("black_ash_stairs");
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 5;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
