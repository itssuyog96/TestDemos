package com.diksha;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PaymentSer
 */
@WebServlet("/payment.do")
public class PaymentSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentSer() {
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
		doGet(request, response);
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		Date date = new Date();
		HttpSession session = request.getSession();
		String timeStamp=date.toString();
		String am=request.getParameter("amount");
		int amount=Integer.parseInt(am);
		int accNo = Integer.parseInt(session.getAttribute("AccoNo").toString()) ;
		int facId = Integer.parseInt(request.getParameter("facId"));
		
		System.out.println(timeStamp);
		System.out.println(am);
		System.out.println(amount);
		System.out.println(accNo);
		String a = FacilityDOA.getConsumeFromID(accNo);
		String p=FacilityDOA.getProviderFromID(accNo);
		System.out.println(a);
		System.out.println(p);
			PaymentDOA accDAO = new PaymentDOA();
			System.out.println("HI 3");
			PaymentIn account = new PaymentIn();
			account.setAccno(accNo);
			account.setPaybal(amount);
			account.setDateofpay(timeStamp);
			account.setPaytype(p);
			account.setConN(a);
			account.setFacId(facId);
			int temp=0;
			int amt=AccountDOA.GetBal(accNo);
			if(amount<amt)
			{
				temp=amt-amount;
			}
			System.out.println(amt);
			accDAO.create(account);
			
			Boolean b=AccountDOA.ChangeBal(accNo,temp); 
			
			if(b==true)
			{
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('Payment Successful');");
			    out.println("location='Payment.jsp';");
			    out.println("</script>"); 
			}
			else
			{
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('Payment Not Successful');");
			    out.println("location='Payment.jsp';");
			    out.println("</script>"); 
			}
			   
					   // System.out.println(account.size());
					   // Iterator<FacilityIn> it= faclist.iterator();
					
			
			
		
				

	}

	

}
