package br.com.globalcode.minecraft.mod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.minecart.MinecartCollisionEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;

public class Explosao {

    @SubscribeEvent
    public void explode(BreakEvent event) {
            if (event.block != Blocks.diamond_ore) {
                      return;
            }

            event.world.createExplosion(null,
                    event.x, event.y, event.z,
                    10, true);
    }	

    @SubscribeEvent
    public void explode(LivingHurtEvent event) {
            if (event.source != DamageSource.anvil) {
                    return;
            }

            Entity entity = event.entity;
            event.entity.worldObj.createExplosion(
                entity,
                entity.posX,
                entity.posY,
                entity.posZ,
                2,
                false);
           }
    @SubscribeEvent
    public void explode(MinecartCollisionEvent event){
        EntityMinecart minecart = event.minecart;
        minecart.worldObj.createExplosion(
            minecart,
            minecart.posX,
            minecart.posY,
            minecart.posZ,
            2,
            false);
    }
}

