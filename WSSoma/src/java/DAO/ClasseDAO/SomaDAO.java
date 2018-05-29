/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.ClasseDAO;

import DAO.Modelo.Soma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author anderson
 */
public class SomaDAO {
    private Connection banco;
    
    public SomaDAO() throws ClassNotFoundException{
        DAO.Conexao.Fabrica fabrica = new DAO.Conexao.Fabrica();
        
        if(fabrica!=null) banco = fabrica.Conexao();
        else banco = null;
    }
    
    public boolean inserir(DAO.Modelo.Soma soma) throws SQLException{
        String SQL = "INSERT INTO resultadoSoma (a, b, c) VALUES (?, ?, ?)";
        boolean resultado;
        if(banco != null){
        PreparedStatement comando = banco.prepareStatement(SQL);
        
        comando.setInt(1, soma.getA());
        comando.setInt(2, soma.getB());
        comando.setInt(3, soma.getC());
        
        resultado = comando.executeUpdate()>0;
        banco.close();
        }
        else
            resultado = false;
        return resultado;
    }
    
    
}
