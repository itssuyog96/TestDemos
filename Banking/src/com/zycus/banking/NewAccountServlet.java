package com.zycus.banking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewAccountServlet
 */
@WebServlet(description = "Open new account", urlPatterns = { "/new-account.do" })
public class NewAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String title = request.getParameter("title");		
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String dob = request.getParameter("dob");
		
		if(title == null || firstName == null || lastName == null || dob == null || title.equals("") || firstName.equals("") || lastName.equals("") || dob.equals("")) {
			response.sendError(500, "Invalid/Empty input");
			return;
		}
		
		if(firstName.length() < 2 || lastName.length() < 2) {
			response.sendRedirect("index.html");
		}
				
		//=============================================
		//TODO: Start a thread to put data in database
		//=============================================
		
		
		PrintWriter out = response.getWriter();
		
		out.println(WebTemplate.getHeaderFor("New Account"));
		out.println("<br/><span style=\"padding-left:10px;\"><strong>"+title+". "+firstName+", your account creation request is under process.</strong></span>");
		out.println("Date of Birth: " + dob);
		out.println(WebTemplate.getFooter());
		
		
		
	}

}
