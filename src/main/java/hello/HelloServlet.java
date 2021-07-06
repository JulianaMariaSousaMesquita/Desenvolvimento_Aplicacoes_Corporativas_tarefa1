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
	LocalDateTime date = LocalDateTime.now();

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
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" +ola+ ", " +nome+ "!</h1>");
            out.println("<p>São " +this.date.getHour()+ "h do dia " +this.date.getDayOfMonth()+"/"+this.date.getMonthValue()+ " de "+this.date.getYear()+"</p>");
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
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" +ola+ ", " +nome+"!</h1>");
            out.println("<p>São " +this.date.getHour()+ "h do dia " +this.date.getDayOfMonth()+"/"+this.date.getMonthValue()+ " de "+this.date.getYear()+"</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public String cumprimentos(String lang) {
    	
    	ArrayList<String> porGreeting = new ArrayList<>(Arrays.asList("Bom dia", "Boa tarde", "Boa noite"));
    	ArrayList<String> engGreeting = new ArrayList<>(Arrays.asList("Good morning", "Good afternoon", "Good night"));
    	ArrayList<String> gerGreeting = new ArrayList<>(Arrays.asList("Guden morgen", "Guden tag", "Gute nacht"));
    	ArrayList<String> spaGreeting = new ArrayList<>(Arrays.asList("Buen día", "Buenas tardes", "Buenas noches"));
    	ArrayList<String> freGreeting = new ArrayList<>(Arrays.asList("Bonjuor", "Bon aprés-midi", "Bonne nuit"));
    	ArrayList<String> speGreeting = new ArrayList<>(Arrays.asList("Bonan matenon", "Bonan posttagmezon", "Bonan nokton"));
    	
    	String message = "";
    	switch (lang) {
		case "por":
			if(this.date.getHour() > 6 && this.date.getHour() < 12) {
				message = porGreeting.get(0);
			} else if(this.date.getHour() > 12 && this.date.getHour() < 18) {
				message = porGreeting.get(1);
			} else {
				message = porGreeting.get(2);
			}
			break;
		case "eng":
			if(this.date.getHour() > 6 && this.date.getHour() < 12) {
				message = engGreeting.get(0);
			} else if(this.date.getHour() > 12 && this.date.getHour() < 18) {
				message = engGreeting.get(1);
			} else {
				message = engGreeting.get(2);
			}
			break;
		case "ger":
			if(this.date.getHour() > 6 && this.date.getHour() < 12) {
				message = gerGreeting.get(0);
			} else if(this.date.getHour() > 12 && this.date.getHour() < 18) {
				message = gerGreeting.get(1);
			} else {
				message = gerGreeting.get(2);
			}
			break;
		case "spa":
			if(this.date.getHour() > 6 && this.date.getHour() < 12) {
				message = spaGreeting.get(0);
			} else if(this.date.getHour() > 12 && this.date.getHour() < 18) {
				message = spaGreeting.get(1);
			} else {
				message = spaGreeting.get(2);
			}
			break;
		case "fre":
			if(this.date.getHour() > 6 && this.date.getHour() < 12) {
				message = freGreeting.get(0);
			} else if(this.date.getHour() > 12 && this.date.getHour() < 18) {
				message = freGreeting.get(1);
			} else {
				message = freGreeting.get(2);
			}
			break;
		case "spe":
			if(this.date.getHour() > 6 && this.date.getHour() < 12) {
				message = speGreeting.get(0);
			} else if(this.date.getHour() > 12 && this.date.getHour() < 18) {
				message = speGreeting.get(1);
			} else {
				message = speGreeting.get(2);
			}
			break;
		default:
			message = "erro";
			break;
		}
    	
    	return message;
    }
}
