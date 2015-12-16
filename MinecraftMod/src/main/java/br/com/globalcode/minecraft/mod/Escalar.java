package br.com.globalcode.minecraft.mod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class Escalar {
	@SubscribeEvent
	public void climbWall(LivingUpdateEvent event) {
		if (!(event.entity instanceof EntitySnowman) &&
			!(event.entity instanceof EntityIronGolem)) {
			return;
		}

		if (!event.entity.isCollidedHorizontally) {
			return;
		}

		event.entity.motionY = 0.5;
	}
}
