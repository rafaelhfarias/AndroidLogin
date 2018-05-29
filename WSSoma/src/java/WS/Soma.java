/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import Operacoes.Matematica.OperacaoSoma;
import java.sql.SQLException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author anderson
 */
@WebService(serviceName = "Soma")
public class Soma {

    /**
     * Servico Web de Soma
     * @param a
     * @param b
     * @return 
     */
    @WebMethod(operationName = "Soma")
    public int soma(@WebParam(name = "primeiroValor") int a, @WebParam(name = "segundoValor")int b)  {
        try{
            OperacaoSoma calculo = new OperacaoSoma(a, b);
            return calculo.getResultado();
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return 0;
    }
}
