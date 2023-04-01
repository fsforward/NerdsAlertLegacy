package com.fsforward.nerdsalertlegacy.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.IWorld;

import java.util.Map;
import java.util.HashMap;

import com.fsforward.nerdsalertlegacy.NerdsalertLegacyModVariables;
import com.fsforward.nerdsalertlegacy.NerdsalertLegacyMod;

public class IsNotThunderingProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onWorldTick(TickEvent.WorldTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				IWorld world = event.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("world", world);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NerdsalertLegacyMod.LOGGER.warn("Failed to load dependency world for procedure IsNotThundering!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (!world.getWorldInfo().isThundering()) {
			NerdsalertLegacyModVariables.WorldVariables.get(world).IsNotThunder = (true);
			NerdsalertLegacyModVariables.WorldVariables.get(world).syncData(world);
		} else {
			NerdsalertLegacyModVariables.WorldVariables.get(world).IsNotThunder = (false);
			NerdsalertLegacyModVariables.WorldVariables.get(world).syncData(world);
		}
		return NerdsalertLegacyModVariables.WorldVariables.get(world).IsNotThunder;
	}
}
