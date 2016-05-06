package com.lothrazar.cyclicmagic.util;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class UtilSound {
//REF BROKEN http://www.minecraftforge.net/forum/index.php?topic=37547.0
	public static final float		volume				= 1.0F;
	public static final float		pitch					= 1.0F;
	public static final boolean	distanceDelay	= false;

	public static void playSoundPlaceBlock(EntityPlayer player,BlockPos pos, Block block) {
		BlockPos here = (pos == null) ? player.getPosition() : pos;
		
		if(block != null && block.getStepSound() != null){
			playSound(player ,here,block.getStepSound().getPlaceSound(),SoundCategory.BLOCKS);
		}
	}
	public static void playSound(EntityPlayer player, BlockPos pos,SoundEvent thunk) {
		BlockPos here = (pos == null) ? player.getPosition() : pos;
		playSound(player,here,thunk,player.getSoundCategory());
	}

	public static void playSound(EntityPlayer player,BlockPos pos, SoundEvent soundIn, SoundCategory cat) {
		BlockPos here = (pos == null) ? player.getPosition() : pos;
		
		System.out.println("playSound "+soundIn.toString());
		
		player.worldObj.playSound(player, here, soundIn, cat, volume, pitch);
	}
	
	
	
	
	
	public static void playSound(World worldObj, BlockPos pos, SoundEvent soundIn, SoundCategory category) {

		worldObj.playSound(pos.getX(),pos.getY(),pos.getZ(), soundIn, category, volume, pitch, distanceDelay);
	
	}

}
