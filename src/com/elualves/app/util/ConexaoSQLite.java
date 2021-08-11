package com.elualves.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexaoSQLite {

    Connection conexao = null;

    public boolean conectar() throws ClassNotFoundException {

        try {
            this.conexao = DriverManager.getConnection("jdbc:sqlite:./db/db_servidor.db");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean desconectar() {
        try {
            if (this.conexao.isClosed() == false) {
                this.conexao.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public PreparedStatement criarPreparedStatement(String pSQL, int RETURN_GENERATED_KEYS) {
        try {
            return conexao.prepareStatement(pSQL, RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public Connection getConnection() {
        return this.conexao;
    }

    public PreparedStatement criarPreparedStatement(String sql) throws SQLException {
        try {
            return this.conexao.prepareStatement(sql);
        } catch (SQLException e) {
            return null;

        }
    }
}
