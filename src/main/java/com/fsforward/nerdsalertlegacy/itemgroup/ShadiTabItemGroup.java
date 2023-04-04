
package com.fsforward.nerdsalertlegacy.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import com.fsforward.nerdsalertlegacy.item.ShadiCrystalItem;
import com.fsforward.nerdsalertlegacy.NerdsalertLegacyModElements;

@NerdsalertLegacyModElements.ModElement.Tag
public class ShadiTabItemGroup extends NerdsalertLegacyModElements.ModElement {
	public ShadiTabItemGroup(NerdsalertLegacyModElements instance) {
		super(instance, 283);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabshadi_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ShadiCrystalItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static ItemGroup tab;
}
