package teamport.projectiles;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import teamport.projectiles.core.item.EPItems;
import turniplabs.halplibe.util.GameStartEntrypoint;


public class ElementalProjectiles implements ModInitializer, GameStartEntrypoint {
    public static final String MOD_ID = "projectiles";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Elemental Projectiles initialized.");
    }

	@Override
	public void beforeGameStart() {
		new EPConfig();
		new EPItems();
	}

	@Override
	public void afterGameStart() {

	}
}
