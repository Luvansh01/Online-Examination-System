package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class MCQServlet
 */
public class MCQServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MCQServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String topic = request.getParameter("topic");

        if (topic == null) {
            // Handle the case where no topic is selected
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Topic is missing");
            return;
        }

        // Forward based on the topic parameter
        switch (topic) {
            case "C":
                request.setAttribute("C", topic);
                request.getRequestDispatcher("Cmcqzone.html").forward(request, response);
                break;
            case "CPlus":
                request.setAttribute("CPlus", topic);
                request.getRequestDispatcher("CPlusmcqzone.html").forward(request, response);
                break;
            case "Java":
                request.setAttribute("Java", topic);
                request.getRequestDispatcher("Javamcqzone.html").forward(request, response);
                break;
            case "Servlet":
                request.setAttribute("Servlet", topic);
                request.getRequestDispatcher("Servletmcqzone.html").forward(request, response);
                break;
            case "Sql":
                request.setAttribute("Sql", topic);
                request.getRequestDispatcher("Sqlmcqzone.html").forward(request, response);
                break;
            default:
                // Handle the case where an unknown topic is selected
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Unknown topic");
                break;
        }
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
















