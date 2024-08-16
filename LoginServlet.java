package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.model.ValidateLogin;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		
		
		ValidateLogin vLogin= new ValidateLogin();
		 if (vLogin.checkLogin(user, pass)) {
		        // Redirect to aftersignup.html if login is successful
		        response.sendRedirect("afterLogin.html");
		    } else {
		        // Set response content type and print login failed message
//		        response.setContentType("text/html");
//		        PrintWriter writer1 = response.getWriter();
//		        writer1.println("<html><body>");
//		        writer1.println("<h1>Login Failed!!</h1>");
//		        writer1.println("</body></html>");
		    	writer.println("Log in failed!");
		    }
	}

}
