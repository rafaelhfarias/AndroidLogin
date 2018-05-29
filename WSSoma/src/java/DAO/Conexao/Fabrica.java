/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author anderson
 */
public class Fabrica {
    private String servidor, porta, base, login, senha;
    
    public Fabrica(){
        servidor = "localhost";
        porta = "3306";
        base = "soma";
        login = "root";
        senha = "123456";
    }
    
    public Connection Conexao() throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://" + this.getServidor()+
                ":" + this.getPorta() + "/" + getBase(), this.getLogin(), this.getSenha());
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getPorta() {
        return porta;
    }

    public void setPorta(String porta) {
        this.porta = porta;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
