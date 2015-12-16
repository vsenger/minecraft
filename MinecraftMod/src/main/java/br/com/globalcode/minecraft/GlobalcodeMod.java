package br.com.globalcode.minecraft;

import br.com.globalcode.minecraft.mod.Escalar;
import br.com.globalcode.minecraft.mod.Explosao;
import br.com.globalcode.minecraft.mod.Paraquedas;
import br.com.globalcode.minecraft.mod.QuebrarBloco;
import br.com.globalcode.minecraft.mod.SuperPulo;
import br.com.globalcode.minecraft.mod.Zumbis;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

@Mod(modid = GlobalcodeMod.MODID, version = GlobalcodeMod.VERSION)
public class GlobalcodeMod {

    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // some example code
        System.out.println("DIRT BLOCK >> " + Blocks.dirt.getUnlocalizedName());
        MinecraftForge.EVENT_BUS.register(new Escalar());
        MinecraftForge.EVENT_BUS.register(new Paraquedas());
        MinecraftForge.EVENT_BUS.register(new SuperPulo());

        MinecraftForge.EVENT_BUS.register(new Explosao());
        MinecraftForge.EVENT_BUS.register(new QuebrarBloco());
        MinecraftForge.EVENT_BUS.register(new Zumbis());

    }

    public void mqttInit() {
        try {
            MqttClient client = new MqttClient(
                    "tcp://iot.eclipse.org:1883", //URI
                    MqttClient.generateClientId(), //ClientId
                    new MemoryPersistence()); //Persistence*/
        } catch (Exception e) {
        }

    }
}
