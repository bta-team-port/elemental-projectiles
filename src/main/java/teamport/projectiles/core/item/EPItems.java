package teamport.projectiles.core.item;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemBow;
import net.minecraft.core.util.collection.NamespaceID;
import teamport.projectiles.EPConfig;
import turniplabs.halplibe.helper.ItemBuilder;

import static teamport.projectiles.ElementalProjectiles.MOD_ID;

public class EPItems {
	private static int startingID = EPConfig.CFG.getInt("IDs.startingItemID");
	private static int nextID() {
		return startingID++;
	}

	private static String name(String s) {
		return String.format("%s:%s", MOD_ID, s);
	}

	public static Item AMMO_ARROW_EGG;
	public static Item AMMO_ARROW_EXPLOSIVE;
	public static Item AMMO_ARROW_FIRE;
	public static Item AMMO_ARROW_ICE;
	public static Item AMMO_ARROW_LIGHTNING;
	public static Item TOOL_BOW_HOMING;

	static {
		AMMO_ARROW_EGG = new ItemBuilder(MOD_ID)
			.setIcon("projectiles:item/arrow/egg")
			.build(new Item("ammo.arrow.egg", name("ammo_arrow_egg"), nextID()));

		AMMO_ARROW_EXPLOSIVE = new ItemBuilder(MOD_ID)
			.setIcon("projectiles:item/arrow/explosive")
			.build(new Item("ammo.arrow.explosive", name("ammo_arrow_explosive"), nextID()));

		AMMO_ARROW_FIRE = new ItemBuilder(MOD_ID)
			.setIcon("projectiles:item/arrow/fire")
			.build(new Item("ammo.arrow.fire", name("ammo_arrow_fire"), nextID()));

		AMMO_ARROW_ICE = new ItemBuilder(MOD_ID)
			.setIcon("projectiles:item/arrow/ice")
			.build(new Item("ammo.arrow.ice", name("ammo_arrow_ice"), nextID()));

		AMMO_ARROW_LIGHTNING = new ItemBuilder(MOD_ID)
			.setIcon("projectiles:item/arrow/lightning")
			.build(new Item("ammo.arrow.lightning", name("ammo_arrow_lightning"), nextID()));

		TOOL_BOW_HOMING = new ItemBuilder(MOD_ID)
			.setIcon("projectiles:item/homing_bow")
			.build(new Item("tool.bow.homing", name("tool_bow_homing"), nextID()));
	}
}
