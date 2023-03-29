
package net.mcreator.nerdsalertlegacy.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.nerdsalertlegacy.item.JorditeIngotItem;
import net.mcreator.nerdsalertlegacy.NerdsalertLegacyModElements;

@NerdsalertLegacyModElements.ModElement.Tag
public class JorditeTabItemGroup extends NerdsalertLegacyModElements.ModElement {
	public JorditeTabItemGroup(NerdsalertLegacyModElements instance) {
		super(instance, 53);
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
