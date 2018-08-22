package com.diksha;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FacilitySer
 */
@WebServlet("/facility.do")
public class FacilitySer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacilitySer() {
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
		
		
		
		String title1=request.getParameter("title1");
		String title2=request.getParameter("title2");
		String ConsumerNo=request.getParameter("ConsumerNo");
		String Electric_Bill=request.getParameter("Electric_Bill");
		String Phone_Bill=request.getParameter("Phone_Bill");
		
		
		if(title1==null && title2==null)
		{
			return;
		}
		
		System.out.println("HI 1");
		//String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		HttpSession session = request.getSession();
		System.out.println("HI 2");
		int id =  Integer.parseInt(session.getAttribute("cust_id").toString());
		int accNo = AccountDOA.getIdFromCustID(id);
		//System.out.println(id);
		
		//System.out.println(customerId);
		
		FacilityDOA accDAO = new FacilityDOA();
		System.out.println("HI 3");
		FacilityIn account = new FacilityIn();
		account.setAccno(accNo);
		//account.setProvider(r);
		//account.setDateofpay(timeStamp);
		
		account.setConN(ConsumerNo);
		if(title1==null)
		{
			account.setPaytype(title2);
			account.setProvider(Phone_Bill);
		}
		if(title2==null)
		{
			account.setPaytype(title1);
			account.setProvider(Electric_Bill);
		}
		
		 System.out.println(account);
		 accDAO.create(account);
	
		//session.setAttribute("AccoNo", customerId);
		
		out.println("<script type=\"text/javascript\">");
	    out.println("alert('Your facility have been added, Add more facility OR Press Done for login');");
	    out.println("location='facility.jsp';");
	    out.println("</script>"); 
		
	}

}
