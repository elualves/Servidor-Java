/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elualves.app.util;

import java.io.IOException;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cliente
 */
public class CapituraIP {

    public String getIpLocalhost() {
        ConnInternet ci = new ConnInternet();
        try {
            if (ci.conectado("http://www.google.com.br")) {
                String ip = InetAddress.getLocalHost().getHostAddress();
                return ip;
            }
        } catch (IOException ex) {
            Logger.getLogger(ValidaIP.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR:" + ex);

        }
        return null;
        // String ip = "192.168.1.5";
        //return ip;
    }

    public static void main(String[] args) {
        CapituraIP ci = new CapituraIP();
        String ip = ci.getIpLocalhost();
        System.out.println("IP: " + ip);
    }

}
