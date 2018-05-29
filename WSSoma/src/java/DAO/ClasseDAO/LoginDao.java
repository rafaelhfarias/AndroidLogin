/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.ClasseDAO;

import DAO.Modelo.Soma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author anderson
 */
public class LoginDao {
    private Connection banco;
    
    public LoginDao() throws ClassNotFoundException{
        DAO.Conexao.Fabrica fabrica = new DAO.Conexao.Fabrica();
        
        if(fabrica!=null) banco = fabrica.Conexao();
        else banco = null;
    }
    
    public String busca(DAO.Modelo.Login login) throws SQLException{
        String SQL = "SELECT senha FROM login WHERE user = ?";
        String resultado = new String(); 
        if(banco != null){
            PreparedStatement comando = banco.prepareStatement(SQL);
            comando.setString(1, login.getUser());
            ResultSet rs = comando.executeQuery();
            while(rs.next()) {
                resultado = rs.getString("senha");
                return resultado;
            }
            banco.close();
        }
        return resultado;
    }
    
    
}
