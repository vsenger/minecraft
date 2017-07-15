package br.com.globalcode.minecraft.mod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import br.com.globalcode.basico.Computador;
import br.com.globalcode.minecraft.GlobalcodeMod;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.MqttException;

public class QuebrarBloco {

    String seuNome = "Vinicius";
    static int relayStatus = 0;

    @SubscribeEvent
    public void sendMessage(BreakEvent event) {
        event.
                getPlayer()
                .addChatMessage(
                        new ChatComponentText(
                                EnumChatFormatting.GOLD
                                + seuNome + " quebrou um bloco!"));
        Computador.falar(seuNome + " quebrou um bloco!", true);
        try {
            GlobalcodeMod.client.publish("/iot-surfboard/control", ("relay?" + relayStatus).getBytes(), 0, false);
        } catch (MqttException ex) {
            Logger.getLogger(QuebrarBloco.class.getName()).log(Level.SEVERE, null, ex);
        }
        relayStatus = relayStatus == 1 ? 0 : 1;

    }
}
