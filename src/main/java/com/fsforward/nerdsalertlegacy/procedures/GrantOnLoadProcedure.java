package com.fsforward.nerdsalertlegacy.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

import com.fsforward.nerdsalertlegacy.item.MedkitItem;
import com.fsforward.nerdsalertlegacy.item.BandageItem;
import com.fsforward.nerdsalertlegacy.NerdsalertLegacyModVariables;
import com.fsforward.nerdsalertlegacy.NerdsalertLegacyMod;

public class GrantOnLoadProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			Entity entity = event.getPlayer();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", entity.getPosX());
			dependencies.put("y", entity.getPosY());
			dependencies.put("z", entity.getPosZ());
			dependencies.put("world", entity.world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NerdsalertLegacyMod.LOGGER.warn("Failed to load dependency entity for procedure GrantOnLoad!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (!(entity.getCapability(NerdsalertLegacyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NerdsalertLegacyModVariables.PlayerVariables())).ItemGranted) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(BandageItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(MedkitItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				boolean _setval = (true);
				entity.getCapability(NerdsalertLegacyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ItemGranted = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
