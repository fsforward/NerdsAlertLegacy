
package net.mcreator.nerdsalertlegacy.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.nerdsalertlegacy.itemgroup.SandromythsTabItemGroup;
import net.mcreator.nerdsalertlegacy.NerdsalertLegacyModElements;

@NerdsalertLegacyModElements.ModElement.Tag
public class SandromythsPickaxeItem extends NerdsalertLegacyModElements.ModElement {
	@ObjectHolder("nerdsalert_legacy:sandromyths_pickaxe")
	public static final Item block = null;

	public SandromythsPickaxeItem(NerdsalertLegacyModElements instance) {
		super(instance, 33);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 1750;
			}

			public float getEfficiency() {
				return 8.8f;
			}

			public float getAttackDamage() {
				return 4.2f;
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
		}, 1, -3f, new Item.Properties().group(SandromythsTabItemGroup.tab)) {
		}.setRegistryName("sandromyths_pickaxe"));
	}
}
