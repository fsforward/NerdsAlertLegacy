package net.mcreator.nerdsalertlegacy.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.block.Blocks;

import net.mcreator.nerdsalertlegacy.NerdsalertLegacyMod;

import java.util.Map;

public class BlackAshSaplingGrowthProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NerdsalertLegacyMod.LOGGER.warn("Failed to load dependency world for procedure BlackAshSaplingGrowth!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NerdsalertLegacyMod.LOGGER.warn("Failed to load dependency x for procedure BlackAshSaplingGrowth!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NerdsalertLegacyMod.LOGGER.warn("Failed to load dependency y for procedure BlackAshSaplingGrowth!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NerdsalertLegacyMod.LOGGER.warn("Failed to load dependency z for procedure BlackAshSaplingGrowth!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double R1 = 0;
		R1 = Math.random();
		if (R1 < 0.02) {
			if ((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.AIR
					&& (world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == Blocks.AIR
					&& (world.getBlockState(new BlockPos(x, y + 3, z))).getBlock() == Blocks.AIR) {
				world.setBlockState(new BlockPos(x, y, z), Blocks.AIR.getDefaultState(), 3);
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("nerdsalert_legacy", "blackashtree"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world, new BlockPos(x - 2, y, z - 2),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
			}
		}
	}
}
