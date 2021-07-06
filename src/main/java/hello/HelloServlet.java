/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juh
 */
@WebServlet("/alomundo")
public class HelloServlet extends HttpServlet {
	
	Calendar calendar = new GregorianCalendar();

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
        
        String lang = request.getParameter("lang");
        if(lang==null) {
        	lang = "por";
        }

        String ola = this.cumprimentos(lang);
        
        String nome = request.getParameter("nome");
        if(nome == "") {
        	nome = "Fulano";	
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");
            out.println("<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\r\n"
            		+ "	  <div class=\"container-fluid\">\r\n"
            		+ "	    <a class=\"navbar-brand\" href=\"https://github.com/JulianaMariaSousaMesquita/Desenvolvimento_Aplicacoes_Corporativas_tarefa1/\">Git Hub - Code </a>\r\n"
            		+ "	    <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n"
            		+ "	      <span class=\"navbar-toggler-icon\"></span>\r\n"
            		+ "	    </button>\r\n"
            		+ "	    <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n"
            		+ "	      <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\r\n"
            		+ "	        <li class=\"nav-item\">\r\n"
            		+ "	          <a class=\"nav-link active\" aria-current=\"page\" href=\"https://infinite-savannah-77606.herokuapp.com/\">Home</a>\r\n"
            		+ "	        </li>\r\n"
            		+ "	        <li class=\"nav-item\">\r\n"
            		+ "	          <a class=\"nav-link\" href=\".\\alomundo?lang=pt&nome=Fulano\">Método GET</a>\r\n"
            		+ "	        </li>\r\n"
            		+ "	        <li class=\"nav-item\">\r\n"
            		+ "	          <a class=\"nav-link\" href=\".\\helloform.html\">Método POST</a>\r\n"
            		+ "	        </li>	        \r\n"
            		+ "	        <li class=\"nav-item\">\r\n"
            		+ "	          <a class=\"nav-link disabled\" href=\"#\" tabindex=\"-1\" aria-disabled=\"true\">Hello World - em outros idiomas</a>\r\n"
            		+ "	        </li>\r\n"
            		+ "	      </ul>\r\n"
            		+ "	      <form class=\"d-flex\">\r\n"
            		+ "	        <input class=\"form-control me-2\" type=\"search\" placeholder=\"Search\" aria-label=\"Search\">\r\n"
            		+ "	        <button class=\"btn btn-outline-success\" type=\"submit\">Buscar</button>\r\n"
            		+ "	      </form>\r\n"
            		+ "	    	</div>\r\n"
            		+ "	  	</div>\r\n"
            		+ "	</nav>\r\n"
            		+ "	<br><br><br>");
            out.println("</head>");
            out.println("<body>");         
            out.println("<div class=\"container\"> <div class=\"row\"> <h1> <div class=\"col-md-9 ms-md-auto\">" +ola+nome+ "!</h1></div>"+"<div class=\"col-md-9 ms-md-auto\">Horario:"+calendar.get((Calendar.HOUR_OF_DAY))+"</div> <div class=\\\"col-md-9 ms-md-auto\\\"> <a href=\"https://infinite-savannah-77606.herokuapp.com/\" class=\"btn btn-primary btn-lg disabled\" role=\"button\" aria-disabled=\"true\">Voltar</a>  </div></div>");            
            out.println("</body>");
            out.println("</html>");
        }
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

    	String lang = request.getParameter("lang");
        if(lang==null) {
        	lang = "por";        	
        }

        String ola = this.cumprimentos(lang);
        
        String nome = request.getParameter("nome");
        if(nome == "") {
        	nome = "Fulano";
        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\r\n"
            		+ "	  <div class=\"container-fluid\">\r\n"
            		+ "	    <a class=\"navbar-brand\" href=\"https://github.com/JulianaMariaSousaMesquita/Desenvolvimento_Aplicacoes_Corporativas_tarefa1/\">Git Hub - Code </a>\r\n"
            		+ "	    <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n"
            		+ "	      <span class=\"navbar-toggler-icon\"></span>\r\n"
            		+ "	    </button>\r\n"
            		+ "	    <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n"
            		+ "	      <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\r\n"
            		+ "	        <li class=\"nav-item\">\r\n"
            		+ "	          <a class=\"nav-link active\" aria-current=\"page\" href=\"https://infinite-savannah-77606.herokuapp.com/\">Home</a>\r\n"
            		+ "	        </li>\r\n"
            		+ "	        <li class=\"nav-item\">\r\n"
            		+ "	          <a class=\"nav-link\" href=\".\\alomundo?lang=pt&nome=Fulano\">Método GET</a>\r\n"
            		+ "	        </li>\r\n"
            		+ "	        <li class=\"nav-item\">\r\n"
            		+ "	          <a class=\"nav-link\" href=\".\\helloform.html\">Método POST</a>\r\n"
            		+ "	        </li>	        \r\n"
            		+ "	        <li class=\"nav-item\">\r\n"
            		+ "	          <a class=\"nav-link disabled\" href=\"#\" tabindex=\"-1\" aria-disabled=\"true\">Hello World - em outros idiomas</a>\r\n"
            		+ "	        </li>\r\n"
            		+ "	      </ul>\r\n"
            		+ "	      <form class=\"d-flex\">\r\n"
            		+ "	        <input class=\"form-control me-2\" type=\"search\" placeholder=\"Search\" aria-label=\"Search\">\r\n"
            		+ "	        <button class=\"btn btn-outline-success\" type=\"submit\">Buscar</button>\r\n"
            		+ "	      </form>\r\n"
            		+ "	    	</div>\r\n"
            		+ "	  	</div>\r\n"
            		+ "	</nav>\r\n"
            		+ "	<br><br><br>");
            out.println("</head>");
            out.println("<body>");         
            out.println("<div class=\"container\"> <div class=\"row\"> <h1> <div class=\"col-md-9 ms-md-auto\">" +ola+nome+ "!</h1></div>"+"<div class=\"col-md-9 ms-md-auto\">Horario:"+calendar.get((Calendar.HOUR_OF_DAY))+"</div> <div class=\\\"col-md-9 ms-md-auto\\\"> <a href=\"https://infinite-savannah-77606.herokuapp.com/\" class=\"btn btn-primary btn-lg disabled\" role=\"button\" aria-disabled=\"true\">Voltar</a>  </div></div>");            
            out.println("</body>");
            out.println("</html>");
        }
    }

    public String cumprimentos(String lang) {
    	String msg = "";
    	switch (lang) {
    	case "":
        case "pt":
        	if(calendar.get(Calendar.HOUR_OF_DAY) <= 12) {
        		msg = "Bom dia, ";
        	}else if(calendar.get((Calendar.HOUR_OF_DAY)) > 12 && (calendar.get(Calendar.HOUR_OF_DAY) <= 18)) {
        		msg = "Boa tarde, ";
        	}else if(calendar.get(Calendar.HOUR_OF_DAY) > 18){
        		msg = "Boa noite, ";
        	}	        	
            break;
        case "en":
        	if(calendar.get(Calendar.HOUR_OF_DAY) <= 12) {
        		msg = "Good morning, ";
        	}else if(calendar.get((Calendar.HOUR_OF_DAY)) > 12 && (calendar.get(Calendar.HOUR_OF_DAY) <= 18)) {
        		msg = "Good afternoon, ";
        	}else if(calendar.get(Calendar.HOUR_OF_DAY) > 18){
        		msg = "Good night, ";
        	}	  
            break;
        case "fr":
        	if(calendar.get(Calendar.HOUR_OF_DAY) <= 12) {
        		msg = "Bonjour, ";
        	}else if(calendar.get((Calendar.HOUR_OF_DAY)) > 12 && (calendar.get(Calendar.HOUR_OF_DAY) <= 18)) {
        		msg = "Bonne apr�s-midi, ";
        	}else if(calendar.get(Calendar.HOUR_OF_DAY) > 18){
        		msg = "Bonne nuit, ";
        	}
            break;
        case "de":
        	if(calendar.get(Calendar.HOUR_OF_DAY) <= 12) {
        		msg = "Guten Morgen, ";
        	}else if(calendar.get((Calendar.HOUR_OF_DAY)) > 12 && (calendar.get(Calendar.HOUR_OF_DAY) <= 18)) {
        		msg = "Guten Nachmittag, ";
        	}else if(calendar.get(Calendar.HOUR_OF_DAY) > 18){
        		msg = "Gute Nacht, ";
        	}	
            break;
        case "es":
        	if(calendar.get(Calendar.HOUR_OF_DAY) <= 12) {
        		msg = "Buenos dias, ";
        	}else if(calendar.get((Calendar.HOUR_OF_DAY)) > 12 && (calendar.get(Calendar.HOUR_OF_DAY) <= 18)) {
        		msg = "Buenas tardes, ";
        	}else if(calendar.get(Calendar.HOUR_OF_DAY) > 18){
        		msg = "Buenas noches, ";
        	}
            break;
        case "no":
        	if(calendar.get(Calendar.HOUR_OF_DAY) <= 12) {
        		msg = "God morgen, ";
        	}else if(calendar.get((Calendar.HOUR_OF_DAY)) > 12 && (calendar.get(Calendar.HOUR_OF_DAY) <= 18)) {
        		msg = "God ettermiddag, ";
        	}else if(calendar.get(Calendar.HOUR_OF_DAY) > 18){
        		msg = "God natt, ";
        	}	 
            break;
		default:
			msg = "Erro - Opção invalida!";
			break;
		}
    	
    	return msg;
    }
}
