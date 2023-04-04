
package com.fsforward.nerdsalertlegacy.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.fsforward.nerdsalertlegacy.procedures.WeatherCondition1Procedure;
import com.fsforward.nerdsalertlegacy.itemgroup.ShadiTabItemGroup;
import com.fsforward.nerdsalertlegacy.NerdsalertLegacyModElements;

@NerdsalertLegacyModElements.ModElement.Tag
public class ShadiJorditeSwordItem extends NerdsalertLegacyModElements.ModElement {
	@ObjectHolder("nerdsalert_legacy:shadi_jordite_sword")
	public static final Item block = null;

	public ShadiJorditeSwordItem(NerdsalertLegacyModElements instance) {
		super(instance, 27);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1250;
			}

			public float getEfficiency() {
				return 10f;
			}

			public float getAttackDamage() {
				return 4.5f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 20;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(JorditeShardItem.block), new ItemStack(TycholaShardItem.block),
						new ItemStack(LoliumShardItem.block), new ItemStack(SandromythsShardItem.block));
			}
		}, 3, -2f, new Item.Properties().group(ShadiTabItemGroup.tab).isImmuneToFire()) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				PlayerEntity entity = Minecraft.getInstance().player;
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				if (!(WeatherCondition1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))) {
					return false;
				}
				return true;
			}
		}.setRegistryName("shadi_jordite_sword"));
	}
}
