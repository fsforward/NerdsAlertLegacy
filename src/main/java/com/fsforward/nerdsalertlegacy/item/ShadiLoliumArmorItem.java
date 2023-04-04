
package com.fsforward.nerdsalertlegacy.item;

import com.fsforward.nerdsalertlegacy.procedures.WeatherCondition1Procedure;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.Entity;

import com.fsforward.nerdsalertlegacy.itemgroup.ShadiTabItemGroup;
import com.fsforward.nerdsalertlegacy.NerdsalertLegacyModElements;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@NerdsalertLegacyModElements.ModElement.Tag
public class ShadiLoliumArmorItem extends NerdsalertLegacyModElements.ModElement {
	@ObjectHolder("nerdsalert_legacy:shadi_lolium_armor_helmet")
	public static final Item helmet = null;
	@ObjectHolder("nerdsalert_legacy:shadi_lolium_armor_chestplate")
	public static final Item body = null;
	@ObjectHolder("nerdsalert_legacy:shadi_lolium_armor_leggings")
	public static final Item legs = null;
	@ObjectHolder("nerdsalert_legacy:shadi_lolium_armor_boots")
	public static final Item boots = null;

	public ShadiLoliumArmorItem(NerdsalertLegacyModElements instance) {
		super(instance, 26);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 26;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{4, 5, 6, 4}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 18;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron"));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(LoliumShardItem.block), new ItemStack(TycholaShardItem.block),
						new ItemStack(JorditeShardItem.block), new ItemStack(SandromythsShardItem.block));
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "shadi_lolium_armor";
			}

			@Override
			public float getToughness() {
				return 0f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		};
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ShadiTabItemGroup.tab).isImmuneToFire()) {
					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "nerdsalert_legacy:textures/models/armor/shadi_lolium__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}
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
				}.setRegistryName("shadi_lolium_armor_helmet"));
		elements.items.add(
				() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(ShadiTabItemGroup.tab).isImmuneToFire()) {
					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "nerdsalert_legacy:textures/models/armor/shadi_lolium__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}
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
				}.setRegistryName("shadi_lolium_armor_chestplate"));
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(ShadiTabItemGroup.tab).isImmuneToFire()) {
					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "nerdsalert_legacy:textures/models/armor/shadi_lolium__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}
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
				}.setRegistryName("shadi_lolium_armor_leggings"));
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(ShadiTabItemGroup.tab).isImmuneToFire()) {
					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "nerdsalert_legacy:textures/models/armor/shadi_lolium__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}
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
				}.setRegistryName("shadi_lolium_armor_boots"));
	}

}
