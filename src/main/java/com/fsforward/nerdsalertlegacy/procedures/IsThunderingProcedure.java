package com.fsforward.nerdsalertlegacy.procedures;

import net.minecraft.world.IWorld;

import java.util.Map;

import com.fsforward.nerdsalertlegacy.NerdsalertLegacyModVariables;
import com.fsforward.nerdsalertlegacy.NerdsalertLegacyMod;

public class IsThunderingProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NerdsalertLegacyMod.LOGGER.warn("Failed to load dependency world for procedure IsThundering!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (world.getWorldInfo().isThundering()) {
			NerdsalertLegacyModVariables.WorldVariables.get(world).IsThunder = (true);
			NerdsalertLegacyModVariables.WorldVariables.get(world).syncData(world);
		} else {
			NerdsalertLegacyModVariables.WorldVariables.get(world).IsThunder = (false);
			NerdsalertLegacyModVariables.WorldVariables.get(world).syncData(world);
		}
		return NerdsalertLegacyModVariables.WorldVariables.get(world).IsThunder;
	}
}
