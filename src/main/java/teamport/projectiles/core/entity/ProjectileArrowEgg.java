package teamport.projectiles.core.entity;

import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.animal.MobChicken;
import net.minecraft.core.entity.projectile.ProjectileArrow;
import net.minecraft.core.util.phys.HitResult;
import net.minecraft.core.world.World;

public class ProjectileArrowEgg extends ProjectileArrow {
	public ProjectileArrowEgg(World world) {
		super(world);
	}

	public ProjectileArrowEgg(World world, int arrowType) {
		super(world, arrowType);
	}

	public ProjectileArrowEgg(World world, double d, double d1, double d2, int arrowType) {
		super(world, d, d1, d2, arrowType);
	}

	public ProjectileArrowEgg(World world, Mob entityliving, boolean doesArrowBelongToPlayer, int arrowType) {
		super(world, entityliving, doesArrowBelongToPlayer, arrowType);
	}

	@Override
	public void onHit(HitResult hitResult) {
		super.onHit(hitResult);
		MobChicken chicken = new MobChicken(world);
		chicken.setPos(x, y, z);
		world.entityJoinedWorld(chicken);
		remove();
	}
}
