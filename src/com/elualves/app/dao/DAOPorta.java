package com.elualves.app.dao;

import com.elualves.app.model.ModelPorta;
import com.elualves.app.util.ConexaoSQLite;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DAOPorta extends ConexaoSQLite {
    
        public ModelPorta buscaGetPorta() throws SQLException, ClassNotFoundException {
        ModelPorta modelPorta= new ModelPorta();
        
        conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        String sql = "SELECT codigo_porta FROM tbl_porta WHERE id = 1";
        preparedStatement = criarPreparedStatement(sql);
        try {
            resultSet = preparedStatement.executeQuery();
            modelPorta.setCodigo(resultSet.getInt("codigo_porta"));

        } catch (SQLException ex) {
            Logger.getLogger(DAOPorta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            System.err.println(e);
        }
        desconectar();
        return modelPorta;
    }

    private int contaLinhas;

    public int buscaContagemDeRegistros() throws SQLException, ClassNotFoundException {
        ModelPorta modelPorta = new ModelPorta();
        conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "SELECT COUNT(*)AS COUNT FROM tbl_porta";
            preparedStatement = criarPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                this.contaLinhas = resultSet.getInt("COUNT");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOPorta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            System.err.println(e);
        }
        desconectar();
        return contaLinhas;
    }

    public boolean atualizarPorta(String vp) throws ClassNotFoundException {

        //ModelPorta modelPorta= new ModelPorta();
        try {
            this.conectar();
            String sql = "UPDATE tbl_porta SET "
                    + "codigo_porta = ? "
                    + " WHERE id = 1 ";

            PreparedStatement preparedStatement = this.criarPreparedStatement(sql);
            preparedStatement.setString(1, vp);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOValidaIP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
