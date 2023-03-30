
package net.mcreator.nerdsalertlegacy.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

import net.mcreator.nerdsalertlegacy.itemgroup.MiscTabItemGroup;
import net.mcreator.nerdsalertlegacy.NerdsalertLegacyModElements;

@NerdsalertLegacyModElements.ModElement.Tag
public class MusicDiscWatchMyBodyDropItem extends NerdsalertLegacyModElements.ModElement {
	@ObjectHolder("nerdsalert_legacy:music_disc_watch_my_body_drop")
	public static final Item block = null;

	public MusicDiscWatchMyBodyDropItem(NerdsalertLegacyModElements instance) {
		super(instance, 53);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, NerdsalertLegacyModElements.sounds
					.get(new ResourceLocation("nerdsalert_legacy:music.instrumental.fsforward.watch_my_body_drop")),
					new Item.Properties().group(MiscTabItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("music_disc_watch_my_body_drop");
		}
	}
}
