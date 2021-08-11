package com.elualves.app.controller;


import com.elualves.app.dao.DAOValidaIP;
import com.elualves.app.model.ModelValidaIP;
import java.net.UnknownHostException;
import java.sql.SQLException;


public class ControllerValidaIP {

    DAOValidaIP dvip = new DAOValidaIP();

    public boolean salvarIPController(ModelValidaIP modelValidaIP) throws ClassNotFoundException, UnknownHostException, SQLException {

        return this.dvip.salvarIPDAO();

    }
}
