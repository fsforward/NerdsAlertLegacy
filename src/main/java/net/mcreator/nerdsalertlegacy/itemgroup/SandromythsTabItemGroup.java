
package net.mcreator.nerdsalertlegacy.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.nerdsalertlegacy.item.SandromythsItem;
import net.mcreator.nerdsalertlegacy.NerdsalertLegacyModElements;

@NerdsalertLegacyModElements.ModElement.Tag
public class SandromythsTabItemGroup extends NerdsalertLegacyModElements.ModElement {
	public SandromythsTabItemGroup(NerdsalertLegacyModElements instance) {
		super(instance, 54);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabsandromyths_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(SandromythsItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
