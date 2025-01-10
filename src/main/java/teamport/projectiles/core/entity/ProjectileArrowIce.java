package teamport.projectiles.core.entity;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.animal.MobChicken;
import net.minecraft.core.entity.projectile.ProjectileArrow;
import net.minecraft.core.util.phys.HitResult;
import net.minecraft.core.world.World;
import teamport.projectiles.core.item.EPItems;

public class ProjectileArrowIce extends ProjectileArrow {
	public ProjectileArrowIce(World world) {
		super(world);
		stack = EPItems.AMMO_ARROW_ICE.getDefaultStack();
	}

	public ProjectileArrowIce(World world, int arrowType) {
		super(world, arrowType);
		stack = EPItems.AMMO_ARROW_ICE.getDefaultStack();
	}

	public ProjectileArrowIce(World world, double d, double d1, double d2, int arrowType) {
		super(world, d, d1, d2, arrowType);
		stack = EPItems.AMMO_ARROW_ICE.getDefaultStack();
	}

	public ProjectileArrowIce(World world, Mob entityliving, boolean doesArrowBelongToPlayer, int arrowType) {
		super(world, entityliving, doesArrowBelongToPlayer, arrowType);
		stack = EPItems.AMMO_ARROW_ICE.getDefaultStack();
	}

	@Override
	public void tick() {
		super.tick();

		if (!isGrounded()) {
			world.spawnParticle("block", x, y, z, 0, 0, 0, Blocks.ICE.id());
			world.spawnParticle("block", x, y, z, 0, 0, 0, Blocks.BLOCK_SNOW.id());
		}
	}

	@Override
	public void onHit(HitResult hitResult) {
		super.onHit(hitResult);

		for (int _x = (int) (x - 1); _x < x + 1 + 1; _x++) {
			for (int _y = (int) (y - 1); _y < y + 1; _y++) {
				for (int _z = (int) (z - 1); _z < z + 1; _z++) {
					if (world.getBlockMaterial(_x, _y, _z) == Material.water) {
						world.setBlockWithNotify(_x, _y, _z, Blocks.PERMAICE.id());
					} else if (world.getBlockMaterial(_x, _y, _z) == Material.lava) {
						world.setBlockWithNotify(_x, _y, _z, Blocks.OBSIDIAN.id());
					} else if (world.getBlockMaterial(_x, _y, _z) == Material.fire) {
						world.setBlockWithNotify(_x, _y, _z, 0);
					} else {
						if (world.getBlock(_x, (int) y, _z) == null && (world.getBlockMaterial(_x, _y, _z) != Material.water || world.getBlockMaterial(_x, _y, _z) != Material.lava)) {
							if (world.getBlock(_x, (int) (y - 1), _z) != null && world.getBlock(_x, (int) (y - 1), _z).isSolidRender() && world.getBlock(_x, (int) (y - 1), _z).getMaterial() != Material.ice) {
								world.setBlockWithNotify(_x, (int) y, _z, Blocks.LAYER_SNOW.id());
							}
						}
					}
				}
			}
		}
	}
}
