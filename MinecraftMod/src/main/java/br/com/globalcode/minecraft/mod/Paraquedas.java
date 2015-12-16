package br.com.globalcode.minecraft.mod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingFallEvent;

public class Paraquedas {
	@SubscribeEvent
	public void deployParachute(PlayerTickEvent event){
		EntityPlayer player = event.player;
		if (!player.isAirBorne || !player.isSneaking()) {
			return;
		}
	}

	@SubscribeEvent
	public void negateFallDamage(LivingFallEvent event) {
		if (!(event.entity instanceof EntityPlayer)) {
			return;
    		}

    	 	EntityPlayer player = (EntityPlayer) event.entity;

    		if (!player.isSneaking()) {
	      		    return;
    		}

    		event.setCanceled(true);
	}
}

