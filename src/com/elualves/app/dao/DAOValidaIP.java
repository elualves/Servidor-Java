package com.elualves.app.dao;

import com.elualves.app.model.ModelValidaIP;
import com.elualves.app.util.ConexaoSQLite;
import com.elualves.app.util.ValidaIP;
import java.net.UnknownHostException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOValidaIP extends ConexaoSQLite {

    private String sql;

    /**
     * Salva o IP Localhost(ValidaIP.getIpLocalhost())
     *
     * @return
     * @throws java.lang.ClassNotFoundException
     * @throws java.net.UnknownHostException
     * @throws java.sql.SQLException
     */
    public boolean salvarIPDAO() throws ClassNotFoundException, UnknownHostException, SQLException {

        conectar();
        ValidaIP vip = new ValidaIP();
        if (vip.getIpLocalhost() != null) {
            String sql = "INSERT INTO tbl_ip("
                    + "codigo_ip) "
                    + "VALUES (?)";
            PreparedStatement preparedStatement = criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
            try {

                preparedStatement.setString(1, vip.getIpLocalhost());
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(DAOValidaIP.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        desconectar();
        return true;
    }

    /**
     * @return retorna IP gravado anteriormente no banco
     * @throws SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public ModelValidaIP buscaGetMVIPDAO() throws SQLException, ClassNotFoundException {
        ModelValidaIP modelValidaIP = new ModelValidaIP();
        conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        String sql = "SELECT codigo_ip FROM tbl_ip WHERE id = 1";
        preparedStatement = criarPreparedStatement(sql);
        try {
            resultSet = preparedStatement.executeQuery();

            modelValidaIP = new ModelValidaIP();
            modelValidaIP.setCodigo(resultSet.getString("codigo_ip"));

        } catch (SQLException ex) {
            Logger.getLogger(DAOValidaIP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            System.err.println(e);
        }
        desconectar();
        return modelValidaIP;
    }

    private int contaLinhas;

    public int buscaContagemDeRegistros() throws SQLException, ClassNotFoundException {
        ModelValidaIP modelValidaIP = new ModelValidaIP();
        conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "SELECT COUNT(*)AS COUNT FROM tbl_ip";
            preparedStatement = criarPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                this.contaLinhas = resultSet.getInt("COUNT");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOValidaIP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            System.err.println(e);
        }
        desconectar();
        return contaLinhas;
    }

    public boolean atualizarIP() throws ClassNotFoundException {

        ModelValidaIP modelValidaIP = new ModelValidaIP();
        try {
            this.conectar();
            sql = "UPDATE tbl_ip SET "
                    + "codigo_ip = ? "
                    + " WHERE id = 1 ";

            PreparedStatement preparedStatement = this.criarPreparedStatement(sql);
            preparedStatement.setString(1, modelValidaIP.getCodigo());
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOValidaIP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
