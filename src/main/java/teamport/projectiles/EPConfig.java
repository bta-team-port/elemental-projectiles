package teamport.projectiles;

import turniplabs.halplibe.util.TomlConfigHandler;
import turniplabs.halplibe.util.toml.Toml;

public class EPConfig {
	private static final Toml TOML = new Toml("Elemental Projectile's TOML Config");
	public static final TomlConfigHandler CFG;

	static {
		TOML.addCategory("IDs")
			.addEntry("startingItemID", "Default: 17000", 17000);

		TOML.addCategory("Tweaks")
			.addEntry("arrowExplosionSize", "Default: 4", 4)
			.addEntry("canArrowCauseStorms", "Default: true", true);

		CFG = new TomlConfigHandler(ElementalProjectiles.MOD_ID, TOML);
	}
}
