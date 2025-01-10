package teamport.projectiles.core.entity;

import net.minecraft.core.entity.EntityLightning;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.animal.MobChicken;
import net.minecraft.core.entity.projectile.ProjectileArrow;
import net.minecraft.core.util.phys.HitResult;
import net.minecraft.core.world.World;
import net.minecraft.core.world.type.overworld.WorldTypeOverworld;
import net.minecraft.core.world.weather.Weathers;
import teamport.projectiles.EPConfig;

public class ProjectileArrowLightning extends ProjectileArrow {
	public ProjectileArrowLightning(World world) {
		super(world);
	}

	public ProjectileArrowLightning(World world, int arrowType) {
		super(world, arrowType);
	}

	public ProjectileArrowLightning(World world, double d, double d1, double d2, int arrowType) {
		super(world, d, d1, d2, arrowType);
	}

	public ProjectileArrowLightning(World world, Mob entityliving, boolean doesArrowBelongToPlayer, int arrowType) {
		super(world, entityliving, doesArrowBelongToPlayer, arrowType);
	}

	@Override
	public void onHit(HitResult hitResult) {
		super.onHit(hitResult);

		if (world.getWorldType() instanceof WorldTypeOverworld) {
			EntityLightning lightning = new EntityLightning(world);
			lightning.setPos(x, y, z);
			world.entityJoinedWorld(lightning);

			if (EPConfig.CFG.getBoolean("Tweaks.canArrowCauseStorms") && random.nextInt(640) == 0) {
				world.weatherManager.overrideWeather(Weathers.OVERWORLD_STORM);
			}

			remove();
		}
	}
}
