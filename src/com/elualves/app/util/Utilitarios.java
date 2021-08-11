package com.elualves.app.util;

import java.awt.Toolkit;
import javax.swing.JFrame;

public class Utilitarios {

    public void inserirIcone(JFrame jF) {
        try {
            jF.setIconImage(Toolkit.getDefaultToolkit().getImage("src/com/elualves/app/imagens/ico_on.png"));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
        public void inserirIcone2(JFrame jF) {
        try {
            jF.setIconImage(Toolkit.getDefaultToolkit().getImage("src/com/elualves/app/imagens/ico_off.png"));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
