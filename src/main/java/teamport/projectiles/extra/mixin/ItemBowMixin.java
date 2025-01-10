package teamport.projectiles.extra.mixin;

import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemBow;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import teamport.projectiles.core.entity.*;
import teamport.projectiles.core.item.EPItems;

@Mixin(value = ItemBow.class, remap = false)
public abstract class ItemBowMixin extends Item {
	public ItemBowMixin(String translationKey, String namespaceId, int id) {
		super(translationKey, namespaceId, id);
	}

	@Inject(method = "onUseItem", at = @At("HEAD"), cancellable = true)
	private void projectiles_onUseBow(ItemStack itemStack, World world, Player player, CallbackInfoReturnable<ItemStack> cir) {
		if (player.inventory.consumeInventoryItem(EPItems.AMMO_ARROW_EGG.id)) {
			itemStack.damageItem(1, player);
			world.playSoundAtEntity(player,
				player,
				"random.bow",
				0.3F,
				1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));

			if (!world.isClientSide) {
				world.entityJoinedWorld(new ProjectileArrowEgg(world, player, true, 0));
			}

			cir.setReturnValue(itemStack);
		} else if (player.inventory.consumeInventoryItem(EPItems.AMMO_ARROW_EXPLOSIVE.id)) {
			itemStack.damageItem(1, player);
			world.playSoundAtEntity(player,
				player,
				"random.bow",
				0.3F,
				1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));

			if (!world.isClientSide) {
				world.entityJoinedWorld(new ProjectileArrowExplosive(world, player, true, 0));
			}

			cir.setReturnValue(itemStack);
		}  else if (player.inventory.consumeInventoryItem(EPItems.AMMO_ARROW_FIRE.id)) {
			itemStack.damageItem(1, player);
			world.playSoundAtEntity(player,
				player,
				"random.bow",
				0.3F,
				1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));

			if (!world.isClientSide) {
				world.entityJoinedWorld(new ProjectileArrowFire(world, player, true, 0));
			}

			cir.setReturnValue(itemStack);
		} else if (player.inventory.consumeInventoryItem(EPItems.AMMO_ARROW_ICE.id)) {
			itemStack.damageItem(1, player);
			world.playSoundAtEntity(player,
				player,
				"random.bow",
				0.3F,
				1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));

			if (!world.isClientSide) {
				world.entityJoinedWorld(new ProjectileArrowIce(world, player, true, 0));
			}

			cir.setReturnValue(itemStack);
		} else if (player.inventory.consumeInventoryItem(EPItems.AMMO_ARROW_LIGHTNING.id)) {
			itemStack.damageItem(1, player);
			world.playSoundAtEntity(player,
				player,
				"random.bow",
				0.3F,
				1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));

			if (!world.isClientSide) {
				world.entityJoinedWorld(new ProjectileArrowLightning(world, player, true, 0));
			}



			cir.setReturnValue(itemStack);
		}
	}
}
