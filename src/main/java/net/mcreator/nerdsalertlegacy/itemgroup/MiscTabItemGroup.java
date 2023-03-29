
package net.mcreator.nerdsalertlegacy.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.nerdsalertlegacy.item.StringOfGrassItem;
import net.mcreator.nerdsalertlegacy.NerdsalertLegacyModElements;

@NerdsalertLegacyModElements.ModElement.Tag
public class MiscTabItemGroup extends NerdsalertLegacyModElements.ModElement {
	public MiscTabItemGroup(NerdsalertLegacyModElements instance) {
		super(instance, 105);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmisc_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(StringOfGrassItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
