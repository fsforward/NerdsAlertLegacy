
package com.fsforward.nerdsalertlegacy.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import com.fsforward.nerdsalertlegacy.itemgroup.MiscTabItemGroup;
import com.fsforward.nerdsalertlegacy.NerdsalertLegacyModElements;

@NerdsalertLegacyModElements.ModElement.Tag
public class RadiantHarvestCottonBlendItem extends NerdsalertLegacyModElements.ModElement {
	@ObjectHolder("nerdsalert_legacy:radiant_harvest_cotton_blend")
	public static final Item block = null;

	public RadiantHarvestCottonBlendItem(NerdsalertLegacyModElements instance) {
		super(instance, 73);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(MiscTabItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("radiant_harvest_cotton_blend");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
