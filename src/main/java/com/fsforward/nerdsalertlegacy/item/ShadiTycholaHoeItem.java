
package com.fsforward.nerdsalertlegacy.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.fsforward.nerdsalertlegacy.procedures.IsThunderingProcedure;
import com.fsforward.nerdsalertlegacy.itemgroup.TycholaTabItemGroup;
import com.fsforward.nerdsalertlegacy.NerdsalertLegacyModElements;

@NerdsalertLegacyModElements.ModElement.Tag
public class ShadiTycholaHoeItem extends NerdsalertLegacyModElements.ModElement {
	@ObjectHolder("nerdsalert_legacy:shadi_tychola_hoe")
	public static final Item block = null;

	public ShadiTycholaHoeItem(NerdsalertLegacyModElements instance) {
		super(instance, 263);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 412;
			}

			public float getEfficiency() {
				return 7.25f;
			}

			public float getAttackDamage() {
				return 1f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 12;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(TycholaShardItem.block), new ItemStack(LoliumShardItem.block),
						new ItemStack(JorditeShardItem.block), new ItemStack(SandromythsShardItem.block));
			}
		}, 0, -1.3f, new Item.Properties().group(TycholaTabItemGroup.tab).isImmuneToFire()) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				PlayerEntity entity = Minecraft.getInstance().player;
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				if (!(IsThunderingProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))) {
					return false;
				}
				return true;
			}
		}.setRegistryName("shadi_tychola_hoe"));
	}
}
