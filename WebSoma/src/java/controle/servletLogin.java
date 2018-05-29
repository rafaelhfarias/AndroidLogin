package controle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import ws.Login_Service;

/**
 *
 * @author hiphip
 */
public class servletLogin extends HttpServlet {
    @WebServiceRef(wsdlLocation = "http://localhost:8080/WSSoma/Login?WSDL")
    private Login_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     static boolean checkAlphaNumeric(String stringToTest) {
	// convert string to corresponding characters
	char[] chars = stringToTest.toCharArray();
	boolean isNonAlphaNumericCharacter = false;
	//iterate over characters
	for (int i = 0; i < chars.length; i++) {
		char c = chars[i];
		//check if the character is alphanumeric 
		if (!Character.isLetterOrDigit(c)) {
			//if non-alphanumeric, set a flag
			isNonAlphaNumericCharacter = true;
		}
	}
        return !isNonAlphaNumericCharacter;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String a = request.getParameter("a");
            String b = request.getParameter("b");
            if(!checkAlphaNumeric(b) || !checkAlphaNumeric(a)){
                out.println("false");
                return ;
            }
            out.println(login(a,b));
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private boolean login(java.lang.String primeiroValor, java.lang.String segundoValor) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.Login port = service.getLoginPort();
        return port.login(primeiroValor, segundoValor);
    }

}
