
package com.fsforward.nerdsalertlegacy.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import com.fsforward.nerdsalertlegacy.itemgroup.TycholaTabItemGroup;
import com.fsforward.nerdsalertlegacy.NerdsalertLegacyModElements;

@NerdsalertLegacyModElements.ModElement.Tag
public class TycholaSwordItem extends NerdsalertLegacyModElements.ModElement {
	@ObjectHolder("nerdsalert_legacy:tychola_sword")
	public static final Item block = null;

	public TycholaSwordItem(NerdsalertLegacyModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 275;
			}

			public float getEfficiency() {
				return 5f;
			}

			public float getAttackDamage() {
				return 1.5f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 8;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(TycholaShardItem.block), new ItemStack(LoliumShardItem.block),
						new ItemStack(JorditeShardItem.block), new ItemStack(SandromythsShardItem.block));
			}
		}, 3, -2.4f, new Item.Properties().group(TycholaTabItemGroup.tab).isImmuneToFire()) {
		}.setRegistryName("tychola_sword"));
	}
}
