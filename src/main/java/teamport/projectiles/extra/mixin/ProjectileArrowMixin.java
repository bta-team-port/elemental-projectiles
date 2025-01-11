package teamport.projectiles.extra.mixin;

import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.projectile.Projectile;
import net.minecraft.core.entity.projectile.ProjectileArrow;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.util.phys.HitResult;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import teamport.projectiles.extra.IHomingProjectile;

import java.util.List;

@Mixin(value = ProjectileArrow.class, remap = false)
public abstract class ProjectileArrowMixin extends Projectile implements IHomingProjectile {
	@Shadow
	public abstract boolean isGrounded();

	@Shadow
	public abstract HitResult getHitResult();

	@Unique
	private boolean projectiles_isHoming = false;

	public ProjectileArrowMixin(World world) {
		super(world);
	}

	@Inject(method = "tick", at = @At("TAIL"))
	private void projectiles_homingArrowTick(CallbackInfo ci) {
		if (elemental_projectiles$getIsHoming() && !isGrounded()) {
			List<Mob> nearbyMobs = world.getEntitiesWithinAABB(Mob.class, AABB.getTemporaryBB(x,
				y,
				z,
				x + (double)1,
				y + (double)1,
				z + (double)1).grow(4, 4, 4));

			if (!nearbyMobs.isEmpty()) {
				Mob mob = nearbyMobs.get(random.nextInt(nearbyMobs.size()));
				if (mob != owner) {
					double newXD = mob.x - x;
					double newYD = mob.y - y;
					double newZD = mob.z - z;

					setHeading(newXD, newYD, newZD, defaultProjectileSpeed, 1);
				}
			}
		}
	}

	@Inject(method = "onHit", at = @At("TAIL"))
	private void projectiles_onHit(HitResult hitResult, CallbackInfo ci) {
		if (hitResult.entity != null) {
			projectiles_isHoming = false;
		}
	}

	@Override
	public void elemental_projectiles$setHoming() {
		projectiles_isHoming = true;
	}

	@Override
	public boolean elemental_projectiles$getIsHoming() {
		return projectiles_isHoming;
	}
}
