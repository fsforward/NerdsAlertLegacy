
package net.mcreator.nerdsalertlegacy.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.nerdsalertlegacy.itemgroup.SandromythsTabItemGroup;
import net.mcreator.nerdsalertlegacy.NerdsalertLegacyModElements;

@NerdsalertLegacyModElements.ModElement.Tag
public class SandromythsAxeItem extends NerdsalertLegacyModElements.ModElement {
	@ObjectHolder("nerdsalert_legacy:sandromyths_axe")
	public static final Item block = null;

	public SandromythsAxeItem(NerdsalertLegacyModElements instance) {
		super(instance, 32);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 1750;
			}

			public float getEfficiency() {
				return 8.8f;
			}

			public float getAttackDamage() {
				return 8.2f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 15;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(SandromythsShardItem.block));
			}
		}, 1, -3.2f, new Item.Properties().group(SandromythsTabItemGroup.tab)) {
		}.setRegistryName("sandromyths_axe"));
	}
}
