package teamport.projectiles.extra.mixin;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicDispenser;
import net.minecraft.core.block.BlockLogicVeryRotatable;
import net.minecraft.core.block.entity.TileEntityDispenser;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import teamport.projectiles.core.entity.*;
import teamport.projectiles.core.item.EPItems;

import java.util.Random;

@Mixin(value = BlockLogicDispenser.class, remap = false)
public abstract class BlockLogicDispenserMixin extends BlockLogicVeryRotatable {
	public BlockLogicDispenserMixin(Block<?> block, Material material) {
		super(block, material);
	}

	@Inject(method = "dispenseItem", at = @At(value = "HEAD"), cancellable = true)
	private void projectiles_dispenseElementals(World world, int x, int y, int z, Random random, CallbackInfo ci) {
		Direction direction = BlockLogicVeryRotatable.metaToDirection(world.getBlockMetadata(x, y, z));
		int xOffset = direction.getOffsetX();
		int yOffset = direction.getOffsetY();
		int zOffset = direction.getOffsetZ();
		TileEntityDispenser tileEntity = (TileEntityDispenser)world.getTileEntity(x, y, z);
		ItemStack itemStack = tileEntity.getRandomStackFromInventory();
		double px = (double)x + (double)xOffset * 0.6 + (double)0.5F;
		double py = (double)y + (double)yOffset * 0.6 + (double)0.5F;
		double pz = (double)z + (double)zOffset * 0.6 + (double)0.5F;

		if (itemStack != null) {
			if (itemStack.itemID == EPItems.AMMO_ARROW_EGG.id) {
				ProjectileArrowEgg arrow = new ProjectileArrowEgg(world, px, py, pz, 0);
				arrow.setHeading(xOffset, (double) yOffset + 0.1, zOffset, 1.1F, 6);
				arrow.setDoesArrowBelongToPlayer(true);
				world.entityJoinedWorld(arrow);
				world.playBlockEvent(1002, x, y, z, 0);
				ci.cancel();
			} else if (itemStack.itemID == EPItems.AMMO_ARROW_EXPLOSIVE.id) {
				ProjectileArrowExplosive arrow = new ProjectileArrowExplosive(world, px, py, pz, 0);
				arrow.setHeading(xOffset, (double) yOffset + 0.1, zOffset, 1.1F, 6);
				arrow.setDoesArrowBelongToPlayer(true);
				world.entityJoinedWorld(arrow);
				world.playBlockEvent(1002, x, y, z, 0);
				ci.cancel();
			} else if (itemStack.itemID == EPItems.AMMO_ARROW_FIRE.id) {
				ProjectileArrowFire arrow = new ProjectileArrowFire(world, px, py, pz, 0);
				arrow.setHeading(xOffset, (double) yOffset + 0.1, zOffset, 1.1F, 6);
				arrow.setDoesArrowBelongToPlayer(true);
				world.entityJoinedWorld(arrow);
				world.playBlockEvent(1002, x, y, z, 0);
				ci.cancel();
			} else if (itemStack.itemID == EPItems.AMMO_ARROW_ICE.id) {
				ProjectileArrowIce arrow = new ProjectileArrowIce(world, px, py, pz, 0);
				arrow.setHeading(xOffset, (double) yOffset + 0.1, zOffset, 1.1F, 6);
				arrow.setDoesArrowBelongToPlayer(true);
				world.entityJoinedWorld(arrow);
				world.playBlockEvent(1002, x, y, z, 0);
				ci.cancel();
			} else if (itemStack.itemID == EPItems.AMMO_ARROW_LIGHTNING.id) {
				ProjectileArrowLightning arrow = new ProjectileArrowLightning(world, px, py, pz, 0);
				arrow.setHeading(xOffset, (double)yOffset + 0.1, zOffset, 1.1F, 6);
				arrow.setDoesArrowBelongToPlayer(true);
				world.entityJoinedWorld(arrow);
				world.playBlockEvent(1002, x, y, z, 0);
				ci.cancel();
			}
		}
	}
}
