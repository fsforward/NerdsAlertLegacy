
package net.mcreator.nerdsalertlegacy.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.nerdsalertlegacy.item.ChromiteItem;
import net.mcreator.nerdsalertlegacy.NerdsalertLegacyModElements;

@NerdsalertLegacyModElements.ModElement.Tag
public class ChromiteTabItemGroup extends NerdsalertLegacyModElements.ModElement {
	public ChromiteTabItemGroup(NerdsalertLegacyModElements instance) {
		super(instance, 55);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabchromite_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ChromiteItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
