package com.diksha;
import com.diksha.Account.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AccountSer
 */
@WebServlet("/AccountCreate.do")
public class AccountSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountSer() {
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
		
		
		String balance=request.getParameter("balance");
		String pass=request.getParameter("password");
		//String pass1=request.getParameter("pass1");
		String AccoType=request.getParameter("AccoType");
		int bal=Integer.parseInt(balance);
		int passw=Integer.parseInt(pass);
		HttpSession session = request.getSession();
		
		String PAN = (String) session.getAttribute("PAN");
		
		int customerId = ADDAccDOA.getIdFromPAN(PAN);
		
		AccountDOA accDAO = new AccountDOA();
		
		Account account = new Account();
		account.setCustomerid(customerId);
		account.setAcct(AccoType);
		account.setBalance(bal);
		account.setPass(passw);
		 
		
		accDAO.create(account);
		
			
		session.setAttribute("cust_id", customerId);

		PrintWriter writer = response.getWriter();
		writer.println("<script type=\"text/javascript\">");
		writer.println("alert('Your account creation is under processing, choose the facility... ');");
		writer.println("location='facility.jsp';");
		writer.println("</script>");
		writer.close();
	}

}
