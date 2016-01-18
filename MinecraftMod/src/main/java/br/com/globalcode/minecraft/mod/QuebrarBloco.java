package br.com.globalcode.minecraft.mod;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import br.com.globalcode.basico.Computador;

public class QuebrarBloco {
	String seuNome = "Vinicius";
	
    @SubscribeEvent
    public void sendMessage(BreakEvent event){
        event.
            getPlayer()
            .addChatMessage(
                new ChatComponentText(
                    EnumChatFormatting.GOLD +
                seuNome + " quebrou um bloco!"));
        Computador.falar(seuNome + " quebrou um bloco!", true);
    }
}
