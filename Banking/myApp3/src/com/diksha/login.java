package com.diksha;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/login.do")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String AccoNo=request.getParameter("AccoNo");
		String password=request.getParameter("password");
		int AccoNum=Integer.parseInt(AccoNo);
		int pass=Integer.parseInt(password);
		loginDOA l=new loginDOA();
		if(l.findById(AccoNum,pass))
		{
			HttpSession session = request.getSession();
			session.setAttribute("AccoNo", AccoNo);
			
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('You are getting logged in');");
		    out.println("location='loggedin.html';");
		    out.println("</script>"); 
		}
		else
		{
			
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Wrong password or Account number');");
		    out.println("location='Index.html';");
		    out.println("</script>"); 
		}
		
		
		
		
	}

}
