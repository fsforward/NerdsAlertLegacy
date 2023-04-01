
package com.fsforward.nerdsalertlegacy.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import com.fsforward.nerdsalertlegacy.item.JorditeIngotItem;
import com.fsforward.nerdsalertlegacy.NerdsalertLegacyModElements;

@NerdsalertLegacyModElements.ModElement.Tag
public class JorditeTabItemGroup extends NerdsalertLegacyModElements.ModElement {
	public JorditeTabItemGroup(NerdsalertLegacyModElements instance) {
		super(instance, 98);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabjordite_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(JorditeIngotItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
