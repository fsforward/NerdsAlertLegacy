
package com.fsforward.nerdsalertlegacy.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import com.fsforward.nerdsalertlegacy.item.TropicalFishTinCanItem;
import com.fsforward.nerdsalertlegacy.NerdsalertLegacyModElements;

@NerdsalertLegacyModElements.ModElement.Tag
public class FoodTabItemGroup extends NerdsalertLegacyModElements.ModElement {
	public FoodTabItemGroup(NerdsalertLegacyModElements instance) {
		super(instance, 284);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabfood_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(TropicalFishTinCanItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
