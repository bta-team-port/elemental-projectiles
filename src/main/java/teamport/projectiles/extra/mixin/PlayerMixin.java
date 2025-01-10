package teamport.projectiles.extra.mixin;

import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Item;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import teamport.projectiles.core.item.EPItems;

@Mixin(value = Player.class, remap = false)
public abstract class PlayerMixin extends Mob {
	@Shadow
	public abstract boolean hasItem(Item item);

	public PlayerMixin(@Nullable World world) {
		super(world);
	}

	@Inject(method = "getNextArrow", at = @At("HEAD"), cancellable = true)
	private void projectiles_nextArrow(CallbackInfoReturnable<Item> cir) {
		Item projectilesNextArrow;
		if (hasItem(EPItems.AMMO_ARROW_EGG)) {
			projectilesNextArrow = EPItems.AMMO_ARROW_EGG;
			cir.setReturnValue(projectilesNextArrow);
		} else if (hasItem(EPItems.AMMO_ARROW_EXPLOSIVE)) {
			projectilesNextArrow = EPItems.AMMO_ARROW_EXPLOSIVE;
			cir.setReturnValue(projectilesNextArrow);
		} else if (hasItem(EPItems.AMMO_ARROW_FIRE)) {
			projectilesNextArrow = EPItems.AMMO_ARROW_FIRE;
			cir.setReturnValue(projectilesNextArrow);
		} else if (hasItem(EPItems.AMMO_ARROW_ICE)) {
			projectilesNextArrow = EPItems.AMMO_ARROW_ICE;
			cir.setReturnValue(projectilesNextArrow);
		} else if (hasItem(EPItems.AMMO_ARROW_LIGHTNING)) {
			projectilesNextArrow = EPItems.AMMO_ARROW_LIGHTNING;
			cir.setReturnValue(projectilesNextArrow);
		}
	}
}
