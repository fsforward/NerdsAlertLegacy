package net.mcreator.nerdsalertlegacy.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.nerdsalertlegacy.item.TycholaShardItem;
import net.mcreator.nerdsalertlegacy.item.TycholaIngotItem;
import net.mcreator.nerdsalertlegacy.item.SandromythsShardItem;
import net.mcreator.nerdsalertlegacy.item.SandromythsItem;
import net.mcreator.nerdsalertlegacy.item.LoliumShardItem;
import net.mcreator.nerdsalertlegacy.item.LoliumIngotItem;
import net.mcreator.nerdsalertlegacy.item.JorditeShardItem;
import net.mcreator.nerdsalertlegacy.item.JorditeIngotItem;
import net.mcreator.nerdsalertlegacy.NerdsalertLegacyMod;

import java.util.Map;
import java.util.HashMap;

public class OresToShardsProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
			PlayerEntity entity = event.getPlayer();
			if (event.getHand() != entity.getActiveHand()) {
				return;
			}
			double i = event.getPos().getX();
			double j = event.getPos().getY();
			double k = event.getPos().getZ();
			IWorld world = event.getWorld();
			BlockState state = world.getBlockState(event.getPos());
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("direction", event.getFace());
			dependencies.put("blockstate", state);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NerdsalertLegacyMod.LOGGER.warn("Failed to load dependency world for procedure OresToShards!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NerdsalertLegacyMod.LOGGER.warn("Failed to load dependency x for procedure OresToShards!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NerdsalertLegacyMod.LOGGER.warn("Failed to load dependency y for procedure OresToShards!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NerdsalertLegacyMod.LOGGER.warn("Failed to load dependency z for procedure OresToShards!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NerdsalertLegacyMod.LOGGER.warn("Failed to load dependency entity for procedure OresToShards!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == TycholaIngotItem.block) {
			if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.ANDESITE) {
				if (new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
						}
						return false;
					}
				}.checkGamemode(entity)) {
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(TycholaIngotItem.block);
						((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) entity).container.func_234641_j_());
					}
				}
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(TycholaShardItem.block);
					_setstack.setCount((int) 4);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
				.getItem() == TycholaIngotItem.block) {
			if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.ANDESITE) {
				if (new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
						}
						return false;
					}
				}.checkGamemode(entity)) {
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(TycholaIngotItem.block);
						((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) entity).container.func_234641_j_());
					}
				}
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).swing(Hand.OFF_HAND, true);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(TycholaShardItem.block);
					_setstack.setCount((int) 4);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == LoliumIngotItem.block) {
			if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.ANDESITE) {
				if (new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
						}
						return false;
					}
				}.checkGamemode(entity)) {
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(LoliumIngotItem.block);
						((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) entity).container.func_234641_j_());
					}
				}
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(LoliumShardItem.block);
					_setstack.setCount((int) 4);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
				.getItem() == LoliumIngotItem.block) {
			if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.ANDESITE) {
				if (new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
						}
						return false;
					}
				}.checkGamemode(entity)) {
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(LoliumIngotItem.block);
						((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) entity).container.func_234641_j_());
					}
				}
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).swing(Hand.OFF_HAND, true);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(LoliumShardItem.block);
					_setstack.setCount((int) 4);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == JorditeIngotItem.block) {
			if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.ANDESITE) {
				if (new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
						}
						return false;
					}
				}.checkGamemode(entity)) {
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(JorditeIngotItem.block);
						((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) entity).container.func_234641_j_());
					}
				}
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(JorditeShardItem.block);
					_setstack.setCount((int) 4);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
				.getItem() == JorditeIngotItem.block) {
			if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.ANDESITE) {
				if (new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
						}
						return false;
					}
				}.checkGamemode(entity)) {
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(JorditeIngotItem.block);
						((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) entity).container.func_234641_j_());
					}
				}
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).swing(Hand.OFF_HAND, true);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(JorditeShardItem.block);
					_setstack.setCount((int) 4);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == SandromythsItem.block) {
			if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.ANDESITE) {
				if (new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
						}
						return false;
					}
				}.checkGamemode(entity)) {
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(SandromythsItem.block);
						((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) entity).container.func_234641_j_());
					}
				}
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(SandromythsShardItem.block);
					_setstack.setCount((int) 4);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
				.getItem() == SandromythsItem.block) {
			if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.ANDESITE) {
				if (new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
						}
						return false;
					}
				}.checkGamemode(entity)) {
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(SandromythsItem.block);
						((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) entity).container.func_234641_j_());
					}
				}
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).swing(Hand.OFF_HAND, true);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(SandromythsShardItem.block);
					_setstack.setCount((int) 4);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		}
	}
}
