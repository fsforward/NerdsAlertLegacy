
package net.mcreator.nerdsalertlegacy.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.nerdsalertlegacy.itemgroup.MiscTabItemGroup;
import net.mcreator.nerdsalertlegacy.NerdsalertLegacyModElements;

@NerdsalertLegacyModElements.ModElement.Tag
public class GrassRopeItem extends NerdsalertLegacyModElements.ModElement {
	@ObjectHolder("nerdsalert_legacy:grass_rope")
	public static final Item block = null;

	public GrassRopeItem(NerdsalertLegacyModElements instance) {
		super(instance, 43);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(MiscTabItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("grass_rope");
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
