
package net.mcreator.nerdsalertlegacy.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

import net.mcreator.nerdsalertlegacy.itemgroup.MiscTabItemGroup;
import net.mcreator.nerdsalertlegacy.NerdsalertLegacyModElements;

@NerdsalertLegacyModElements.ModElement.Tag
public class MusicDiscLanternItem extends NerdsalertLegacyModElements.ModElement {
	@ObjectHolder("nerdsalert_legacy:music_disc_lantern")
	public static final Item block = null;

	public MusicDiscLanternItem(NerdsalertLegacyModElements instance) {
		super(instance, 292);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, NerdsalertLegacyModElements.sounds.get(new ResourceLocation("nerdsalert_legacy:music.instrumental.nerdsalert.lantern")),
					new Item.Properties().group(MiscTabItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("music_disc_lantern");
		}
	}
}
