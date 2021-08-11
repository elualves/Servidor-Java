package com.elualves.app.model;

import com.elualves.app.util.ValidaIP;

public class ModelValidaIP {

    ValidaIP vip = new ValidaIP();
    private String codigo;

    public ModelValidaIP() {

    }

    public String getCodigoBusca() {
        return codigo;
    }

    public String getCodigo() {
        codigo = vip.getIpLocalhost();
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
