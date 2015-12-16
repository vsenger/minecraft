package br.com.globalcode.minecraft.mod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;

public class SuperPulo {

	@SubscribeEvent
	public void makeJumpHigher(LivingJumpEvent event){
		if (!(event.entity instanceof EntityPlayer)) {
			return;
		}

		event.entity.motionY *= 5;
	}
}
