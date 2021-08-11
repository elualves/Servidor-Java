package com.elualves.app.util;

import com.elualves.app.dao.DAOValidaIP;
import java.io.IOException;
import java.net.InetAddress;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ValidaIP {

    public String getIpLocalhost() {
        // String ip = "192.168.1.50";
        ConnInternet ci = new ConnInternet();
        try {
            if (ci.conectado("http://www.google.com.br")) {
                String ip = InetAddress.getLocalHost().getHostAddress();
                return ip;
            }
        } catch (IOException ex) {
            Logger.getLogger(ValidaIP.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }

    public String buscaIPNoBanco() throws SQLException, ClassNotFoundException {
        DAOValidaIP dvt = new DAOValidaIP();
        String iPDoBanco = dvt.buscaGetMVIPDAO().getCodigoBusca();
        return iPDoBanco;
    }
    
}
