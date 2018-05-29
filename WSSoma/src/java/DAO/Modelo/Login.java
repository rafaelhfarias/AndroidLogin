/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Modelo;

/**
 *
 * @author anderson
 */
public class Login {
    private String user, senha;

    public Login(String a, String b) {
        this.user = a;
        this.senha = b;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String a) {
        this.user = a;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String b) {
        this.senha = b;
    }
}
