
package com.fsforward.nerdsalertlegacy.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import com.fsforward.nerdsalertlegacy.item.LoliumIngotItem;
import com.fsforward.nerdsalertlegacy.NerdsalertLegacyModElements;

@NerdsalertLegacyModElements.ModElement.Tag
public class LoliumTabItemGroup extends NerdsalertLegacyModElements.ModElement {
	public LoliumTabItemGroup(NerdsalertLegacyModElements instance) {
		super(instance, 95);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tablolium_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(LoliumIngotItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
