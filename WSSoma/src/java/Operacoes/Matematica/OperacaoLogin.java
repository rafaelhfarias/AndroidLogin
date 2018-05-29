/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operacoes.Matematica;

import DAO.ClasseDAO.LoginDao;
import DAO.Modelo.Login;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
/**
 *
 * @author anderson
 */
public class OperacaoLogin {
    private Login operacao;
    private boolean resultado;

    public boolean getResultado() {
        return resultado;
    }
    
    public OperacaoLogin(String a, String b) throws SQLException, ClassNotFoundException{
        operacao = new Login(a, b);
        fazLogin();
    }
    
    
  
    private boolean fazLogin() throws SQLException, ClassNotFoundException{
        
        String login = operacao.getUser();
        String senhaHash = operacao.getSenha();
        LoginDao operacaoDAO = new LoginDao();
                
        String senha = operacaoDAO.busca(operacao);
        System.out.println(senha);
        System.out.println(operacao.getSenha());
        
        resultado = senha.equalsIgnoreCase(senhaHash);
        return resultado;
    }
}
