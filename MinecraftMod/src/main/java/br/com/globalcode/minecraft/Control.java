/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.globalcode.minecraft;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author globalcode
 */
public class Control implements MqttCallback {

    static Runtime rt = Runtime.getRuntime();

    public synchronized static void lerJson(String json) {
        //JSONObject jsonObject = (JSONObject) JSONValue.parse(json);
        /*if (jsonObject == null || jsonObject.keySet() == null || jsonObject.keySet().iterator() == null) {
            //System.out.println("Erro json " + data);
            return;
        }

        JSONArray components = (JSONArray) jsonObject.get("components");

        Iterator i = components.iterator();
        while (i.hasNext()) {
            Object oo = i.next();
            JSONObject joo = (JSONObject) oo;
            String thing = joo.get("name").toString();
            String value = joo.get("value").toString();
            found.getThings().get(thing).setLastValue(value);

        }
          */
    }

    public synchronized static void executar(String comando) {
        String comandoOk = comando.replaceAll("execute ", "");
        try {
            System.out.println("Executando " + comandoOk);
            Process pr1 = rt.exec(comandoOk);
        } catch (Exception ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void connectionLost(Throwable cause) {
        System.out.println("Conexão com MQTT perdida");
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        String msg = message.toString();
        System.out.println("Chegou mensagem " + msg);

        if (msg.startsWith("execute ")) { //line-command
            executar(msg);
        } else if (msg.startsWith("{")) { //json
            lerJson(msg);
        }

    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
    }

}
