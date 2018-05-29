/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import Operacoes.Matematica.OperacaoLogin;
import java.sql.SQLException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author anderson
 */
@WebService(serviceName = "Login")
public class Login {

    /**
     * Servico Web de Soma
     * @param a
     * @param b
     * @return 
     */
    @WebMethod(operationName = "Login")
    public boolean login(@WebParam(name = "primeiroValor") String a, @WebParam(name = "segundoValor")String b)  {
        try{
            OperacaoLogin login = new OperacaoLogin(a, b);
            return login.getResultado();
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
            return false;
        }
    }
}
