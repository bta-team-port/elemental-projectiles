package teamport.projectiles.core.recipe;

import net.minecraft.core.block.Blocks;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import teamport.projectiles.core.item.EPItems;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderShaped;
import turniplabs.halplibe.util.RecipeEntrypoint;

import static teamport.projectiles.ElementalProjectiles.MOD_ID;

public class EPRecipes implements RecipeEntrypoint {
	@Override
	public void onRecipesReady() {
		RecipeBuilderShaped arrowTemplate = new RecipeBuilderShaped(MOD_ID, "1", "2", "3")
			.addInput('2', Items.STICK)
			.addInput('3', Items.FEATHER_CHICKEN);

		arrowTemplate.addInput('1', Items.EGG_CHICKEN).create("egg_arrow", EPItems.AMMO_ARROW_EGG);
		arrowTemplate.addInput('1', Items.SULPHUR).create("explosive_arrow", EPItems.AMMO_ARROW_EXPLOSIVE);
		arrowTemplate.addInput('1', Items.COAL).create("fire_arrow_coal", EPItems.AMMO_ARROW_FIRE);
		arrowTemplate.addInput('1', Items.NETHERCOAL).create("fire_arrow_nether_coal", new ItemStack(EPItems.AMMO_ARROW_FIRE, 2));
		arrowTemplate.addInput('1', Blocks.PERMAICE).create("ice_arrow", EPItems.AMMO_ARROW_ICE);
		arrowTemplate.addInput('1', Items.DIAMOND).create("lightning_arrow", EPItems.AMMO_ARROW_LIGHTNING);
	}

	@Override
	public void initNamespaces() {
		RecipeBuilder.initNameSpace(MOD_ID);
	}
}
