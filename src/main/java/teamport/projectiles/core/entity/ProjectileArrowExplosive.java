package teamport.projectiles.core.entity;

import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.animal.MobChicken;
import net.minecraft.core.entity.projectile.ProjectileArrow;
import net.minecraft.core.util.phys.HitResult;
import net.minecraft.core.world.World;
import teamport.projectiles.EPConfig;

public class ProjectileArrowExplosive extends ProjectileArrow {
	public ProjectileArrowExplosive(World world) {
		super(world);
	}

	public ProjectileArrowExplosive(World world, int arrowType) {
		super(world, arrowType);
	}

	public ProjectileArrowExplosive(World world, double d, double d1, double d2, int arrowType) {
		super(world, d, d1, d2, arrowType);
	}

	public ProjectileArrowExplosive(World world, Mob entityliving, boolean doesArrowBelongToPlayer, int arrowType) {
		super(world, entityliving, doesArrowBelongToPlayer, arrowType);
	}

	@Override
	public void tick() {
		super.tick();
		world.spawnParticle("smoke", x, y + (double)0.5F, z, 0, 0, 0, 0);
	}

	@Override
	public void onHit(HitResult hitResult) {
		super.onHit(hitResult);
		world.createExplosion(this, x, y, z, EPConfig.CFG.getInt("Tweaks.arrowExplosionSize"));
		remove();
	}
}
