package teamport.projectiles.core.item;

import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.entity.projectile.ProjectileArrow;
import net.minecraft.core.entity.projectile.ProjectileArrowGolden;
import net.minecraft.core.entity.projectile.ProjectileArrowPurple;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.world.World;
import teamport.projectiles.core.entity.*;
import teamport.projectiles.extra.IHomingProjectile;

public class ItemBowHoming extends Item {
	public ItemBowHoming(String translationKey, String namespaceId, int id) {
		super(translationKey, namespaceId, id);
		setMaxStackSize(1);
	}

	@Override
	public ItemStack onUseItem(ItemStack itemstack, World world, Player player) {
		ItemStack quiverSlot = player.inventory.armorItemInSlot(2);
		if (quiverSlot != null && quiverSlot.itemID == Items.ARMOR_QUIVER.id && quiverSlot.getMetadata() < quiverSlot.getMaxDamage()) {
			player.inventory.armorItemInSlot(2).damageItem(1, player);
			itemstack.damageItem(1, player);
			world.playSoundAtEntity(player, player, "random.bow", 0.3F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!world.isClientSide) {
				IHomingProjectile projectile = (IHomingProjectile) new ProjectileArrow(world, player, true, 0);
				projectile.elemental_projectiles$setHoming();
				world.entityJoinedWorld((Entity) projectile);
			}
		} else if (quiverSlot != null && quiverSlot.itemID == Items.ARMOR_QUIVER_GOLD.id) {
			itemstack.damageItem(1, player);
			world.playSoundAtEntity(player, player, "random.bow", 0.3F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!world.isClientSide) {
				IHomingProjectile projectile = (IHomingProjectile) new ProjectileArrowPurple(world, player, true);
				projectile.elemental_projectiles$setHoming();
				world.entityJoinedWorld((Entity) projectile);
			}
		} else if (player.inventory.consumeInventoryItem(Items.AMMO_ARROW_GOLD.id)) {
			itemstack.damageItem(1, player);
			world.playSoundAtEntity(player, player, "random.bow", 0.3F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!world.isClientSide) {
				IHomingProjectile projectile = (IHomingProjectile) new ProjectileArrowGolden(world, player, true);
				projectile.elemental_projectiles$setHoming();
				world.entityJoinedWorld((Entity) projectile);
			}
		} else if (player.inventory.consumeInventoryItem(Items.AMMO_ARROW.id)) {
			itemstack.damageItem(1, player);
			world.playSoundAtEntity(player, player, "random.bow", 0.3F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!world.isClientSide) {
				IHomingProjectile projectile = (IHomingProjectile) new ProjectileArrow(world, player, true, 0);
				projectile.elemental_projectiles$setHoming();
				world.entityJoinedWorld((Entity) projectile);
			}
		} else if (player.inventory.consumeInventoryItem(EPItems.AMMO_ARROW_EGG.id)) {
			itemstack.damageItem(1, player);
			world.playSoundAtEntity(player, player, "random.bow", 0.3F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!world.isClientSide) {
				IHomingProjectile projectile = (IHomingProjectile) new ProjectileArrowEgg(world, player, true, 0);
				projectile.elemental_projectiles$setHoming();
				world.entityJoinedWorld((Entity) projectile);
			}
		} else if (player.inventory.consumeInventoryItem(EPItems.AMMO_ARROW_EXPLOSIVE.id)) {
			itemstack.damageItem(1, player);
			world.playSoundAtEntity(player, player, "random.bow", 0.3F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!world.isClientSide) {
				IHomingProjectile projectile = (IHomingProjectile) new ProjectileArrowExplosive(world, player, true, 0);
				projectile.elemental_projectiles$setHoming();
				world.entityJoinedWorld((Entity) projectile);
			}
		} else if (player.inventory.consumeInventoryItem(EPItems.AMMO_ARROW_FIRE.id)) {
			itemstack.damageItem(1, player);
			world.playSoundAtEntity(player, player, "random.bow", 0.3F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!world.isClientSide) {
				IHomingProjectile projectile = (IHomingProjectile) new ProjectileArrowFire(world, player, true, 0);
				projectile.elemental_projectiles$setHoming();
				world.entityJoinedWorld((Entity) projectile);
			}
		} else if (player.inventory.consumeInventoryItem(EPItems.AMMO_ARROW_ICE.id)) {
			itemstack.damageItem(1, player);
			world.playSoundAtEntity(player, player, "random.bow", 0.3F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!world.isClientSide) {
				IHomingProjectile projectile = (IHomingProjectile) new ProjectileArrowIce(world, player, true, 0);
				projectile.elemental_projectiles$setHoming();
				world.entityJoinedWorld((Entity) projectile);
			}
		} else if (player.inventory.consumeInventoryItem(EPItems.AMMO_ARROW_LIGHTNING.id)) {
			itemstack.damageItem(1, player);
			world.playSoundAtEntity(player, player, "random.bow", 0.3F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!world.isClientSide) {
				IHomingProjectile projectile = (IHomingProjectile) new ProjectileArrowLightning(world, player, true, 0);
				projectile.elemental_projectiles$setHoming();
				world.entityJoinedWorld((Entity) projectile);
			}
		}

		return itemstack;
	}
}
