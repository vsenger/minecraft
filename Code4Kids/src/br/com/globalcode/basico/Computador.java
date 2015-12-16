/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.globalcode.basico;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author globalcode
 */
public class Computador {

    public static String SPEAK_CMD = "espeak -p10 -k5 -s150 -v pt -f <filename>";
    public static String WELCOME_TEXT = "Welcome to Surfing I.O.T Services ";

    static Runtime rt = Runtime.getRuntime();
    public static void main(String[] args) {
        falar("Olá pessoal, bem-vindos ao coude for quides!",true);
    }
    public synchronized static void falar(String texto, boolean esperar) {
        try {
            File f = new File("speaktemp.txt");
            FileOutputStream fw = new FileOutputStream(f, false);
            BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(fw, "UTF-8"));
            bf.write(texto);
            bf.flush();
            bf.close();
            String comando = SPEAK_CMD.replace("<filename>", f.getAbsolutePath());
            System.out.println("Comando voz " + comando);
            Process pr1 = rt.exec(comando);
            if (esperar) {
                pr1.waitFor();
            }
        } catch (Exception ex) {
            Logger.getLogger(Computador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
