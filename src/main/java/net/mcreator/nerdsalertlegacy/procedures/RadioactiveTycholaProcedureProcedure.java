package net.mcreator.nerdsalertlegacy.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.nerdsalertlegacy.item.RadioactiveTycholaIngotItem;
import net.mcreator.nerdsalertlegacy.block.TycholaOreBlock;
import net.mcreator.nerdsalertlegacy.block.RadioactiveBlockOfTycholaBlock;
import net.mcreator.nerdsalertlegacy.NerdsalertLegacyMod;

import java.util.Map;
import java.util.HashMap;

public class RadioactiveTycholaProcedureProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NerdsalertLegacyMod.LOGGER.warn("Failed to load dependency entity for procedure RadioactiveTycholaProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(RadioactiveBlockOfTycholaBlock.block))
				: false) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 2);
		} else if ((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(RadioactiveTycholaIngotItem.block))
				: false) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
		} else if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(TycholaOreBlock.block)) : false) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 0.5);
		}
	}
}
