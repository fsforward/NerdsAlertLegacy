
package com.fsforward.nerdsalertlegacy.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;
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
public class ShadiSandromythsAxeItem extends NerdsalertLegacyModElements.ModElement {
	@ObjectHolder("nerdsalert_legacy:shadi_sandromyths_axe")
	public static final Item block = null;

	public ShadiSandromythsAxeItem(NerdsalertLegacyModElements instance) {
		super(instance, 34);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 1750;
			}

			public float getEfficiency() {
				return 13.75f;
			}

			public float getAttackDamage() {
				return 10.75f;
			}

			public int getHarvestLevel() {
				return 5;
			}

			public int getEnchantability() {
				return 15;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(SandromythsShardItem.block), new ItemStack(TycholaShardItem.block),
						new ItemStack(LoliumShardItem.block), new ItemStack(JorditeShardItem.block));
			}
		}, 1, -3f, new Item.Properties().group(ShadiTabItemGroup.tab).isImmuneToFire()) {
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
		}.setRegistryName("shadi_sandromyths_axe"));
	}
}
