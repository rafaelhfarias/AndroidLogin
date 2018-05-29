/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operacoes.Matematica;

import DAO.ClasseDAO.SomaDAO;
import DAO.Modelo.Soma;
import java.sql.SQLException;
/**
 *
 * @author anderson
 */
public class OperacaoSoma {
    private Soma operacao;
    private int resultado;

    public int getResultado() {
        return resultado;
    }
    
    public OperacaoSoma(int a, int b) throws SQLException, ClassNotFoundException{
        operacao = new Soma(a, b);
        calculaResultado();
    }
    
    private void calculaResultado() throws SQLException, ClassNotFoundException{
        resultado = operacao.getA() + operacao.getB();
        operacao.setC(resultado);
        System.out.println("A = " + operacao.getA() + " B = "+ operacao.getB() + " C = "+ operacao.getC());
       
        SomaDAO operacaoDAO = new SomaDAO();
        
        operacaoDAO.inserir(operacao);
    }
}
