
package com.fsforward.nerdsalertlegacy.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import com.fsforward.nerdsalertlegacy.itemgroup.TycholaTabItemGroup;
import com.fsforward.nerdsalertlegacy.NerdsalertLegacyModElements;

@NerdsalertLegacyModElements.ModElement.Tag
public class TycholaShovelItem extends NerdsalertLegacyModElements.ModElement {
	@ObjectHolder("nerdsalert_legacy:tychola_shovel")
	public static final Item block = null;

	public TycholaShovelItem(NerdsalertLegacyModElements instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 275;
			}

			public float getEfficiency() {
				return 5f;
			}

			public float getAttackDamage() {
				return 2.25f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 8;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(TycholaShardItem.block));
			}
		}, 1, -3f, new Item.Properties().group(TycholaTabItemGroup.tab)) {
		}.setRegistryName("tychola_shovel"));
	}
}
