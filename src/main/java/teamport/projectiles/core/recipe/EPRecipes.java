package teamport.projectiles.core.recipe;

import teamport.projectiles.ElementalProjectiles;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.RecipeEntrypoint;

public class EPRecipes implements RecipeEntrypoint {
	@Override
	public void onRecipesReady() {

	}

	@Override
	public void initNamespaces() {
		RecipeBuilder.initNameSpace(ElementalProjectiles.MOD_ID);
	}
}
