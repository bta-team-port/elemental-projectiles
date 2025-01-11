package teamport.projectiles.extra.mixin;

import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.generate.feature.WorldFeatureLabyrinth;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import teamport.projectiles.core.item.EPItems;

import java.util.Random;

@Mixin(value = WorldFeatureLabyrinth.class, remap = false)
public abstract class WorldFeatureLabyrinthMixin extends WorldFeature {
	@Shadow
	public ItemStack treasureItem;

	@Shadow
	boolean isCold;

	@Inject(method = "place", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/world/generate/feature/WorldFeatureLabyrinth;canReplace(Lnet/minecraft/core/world/World;III)Z"))
	private void projectiles_placeHomingBow(World world, Random random, int x, int y, int z, CallbackInfoReturnable<Boolean> cir) {
		if (!isCold) {
			treasureItem = random.nextInt(2) == 0 ? Items.ARMOR_QUIVER_GOLD.getDefaultStack() : EPItems.TOOL_BOW_HOMING.getDefaultStack();
		}
	}
}
