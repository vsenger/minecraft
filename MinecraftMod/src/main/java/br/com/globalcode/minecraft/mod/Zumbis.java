package br.com.globalcode.minecraft.mod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class Zumbis {
    @SubscribeEvent
    public void giveArmor(EntityJoinWorldEvent event){
            if (!(event.entity instanceof EntityZombie)) {
                return;
            }

            EntityZombie zombie = (EntityZombie) event.entity;

            zombie.setCurrentItemOrArmor(0, new ItemStack(Items.diamond_axe));
            zombie.setCurrentItemOrArmor(1, new ItemStack(Items.diamond_chestplate));
            zombie.setCurrentItemOrArmor(2, new ItemStack(Items.diamond_leggings));
            zombie.setCurrentItemOrArmor(3, new ItemStack(Items.diamond_boots));
            zombie.setCurrentItemOrArmor(4, new ItemStack(Items.diamond_helmet));
    }

}
