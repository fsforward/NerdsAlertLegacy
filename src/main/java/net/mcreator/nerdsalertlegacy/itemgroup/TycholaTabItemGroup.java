
package net.mcreator.nerdsalertlegacy.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.nerdsalertlegacy.item.TycholaIngotItem;
import net.mcreator.nerdsalertlegacy.NerdsalertLegacyModElements;

@NerdsalertLegacyModElements.ModElement.Tag
public class TycholaTabItemGroup extends NerdsalertLegacyModElements.ModElement {
	public TycholaTabItemGroup(NerdsalertLegacyModElements instance) {
		super(instance, 51);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabtychola_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(TycholaIngotItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
