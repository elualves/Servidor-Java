package com.elualves.app.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ConnInternet {

    public boolean conectado(String endereco) throws MalformedURLException, IOException {
        try {
            URL url = new URL(endereco);
            URLConnection comm = url.openConnection();
            comm.connect();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {

        ConnInternet ci = new ConnInternet();
        boolean verdade = ci.conectado("http://www.google.com.br");

        if (verdade == true) {
            System.out.println("conectado");
        } else {
            System.out.println("não conectado");
        }

    }
}
