
package com.fsforward.nerdsalertlegacy.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import com.fsforward.nerdsalertlegacy.itemgroup.LoliumTabItemGroup;
import com.fsforward.nerdsalertlegacy.NerdsalertLegacyModElements;

@NerdsalertLegacyModElements.ModElement.Tag
public class LoliumAxeItem extends NerdsalertLegacyModElements.ModElement {
	@ObjectHolder("nerdsalert_legacy:lolium_axe")
	public static final Item block = null;

	public LoliumAxeItem(NerdsalertLegacyModElements instance) {
		super(instance, 44);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 400;
			}

			public float getEfficiency() {
				return 7f;
			}

			public float getAttackDamage() {
				return 7f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(LoliumShardItem.block));
			}
		}, 1, -3.15f, new Item.Properties().group(LoliumTabItemGroup.tab)) {
		}.setRegistryName("lolium_axe"));
	}
}
