package teamport.projectiles.core.entity;

import net.minecraft.core.block.Blocks;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.projectile.ProjectileArrow;
import net.minecraft.core.util.phys.HitResult;
import net.minecraft.core.world.World;

public class ProjectileArrowFire extends ProjectileArrow {
	public ProjectileArrowFire(World world) {
		super(world);
	}

	public ProjectileArrowFire(World world, int arrowType) {
		super(world, arrowType);
	}

	public ProjectileArrowFire(World world, double d, double d1, double d2, int arrowType) {
		super(world, d, d1, d2, arrowType);
	}

	public ProjectileArrowFire(World world, Mob entityliving, boolean doesArrowBelongToPlayer, int arrowType) {
		super(world, entityliving, doesArrowBelongToPlayer, arrowType);
	}

	@Override
	public void tick() {
		super.tick();
		world.spawnParticle("flame", x, y, z, 0, 0, 0, Blocks.ICE.id());
		world.spawnParticle("smoke", x, y, z, 0, 0, 0, Blocks.BLOCK_SNOW.id());
	}

	@Override
	public void onHit(HitResult hitResult) {
		super.onHit(hitResult);

		if (hitResult.entity != null) {
			hitResult.entity.remainingFireTicks = 300;
		} else {
			world.setBlockWithNotify((int) x, (int) y, (int) z, Blocks.FIRE.id());
		}

		remove();
	}
}
