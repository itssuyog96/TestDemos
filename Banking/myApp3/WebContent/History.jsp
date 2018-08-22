<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.diksha.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Didact+Gothic"
	rel="stylesheet" />
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<% String id=session.getAttribute("AccoNo").toString();

List<PaymentIn> faclist = PaymentDOA.getDataFromAccNo(Integer.parseInt(id));

Iterator<PaymentIn> it= faclist.iterator();%>


<div id="header-wrapper">
		<div id="header" class="container">
			<div id="logo">
				
			</div>
</div>
</div>
<div id="wrapper">
	<div id="three-column" class="container">
		<div class="title">
			<h2>YOUR FACILITIES</h2>			
			<span class="byline">Easy LifeStyle</span>
		 <form action=details.do method="post">
					<br><br><br>
					<table align="center" border="2">
   					<tr>
        
        			
        			<td>Account Number</td>
        			<td>Balance</td>
        			<td>Date</td>
        			<td>Pay type</td>
        			<td>ConsumerNumber</td>
        			
        
   					</tr>
   					<%for (PaymentIn f:faclist){
	   				%>
     
          			 <tr><td><%= f.getAccno()%></td>
        				<td><%= f.getPaybal()%></td>
        				<td><%= f.getDateofpay()%></td>
        				<td><%= f.getPaytype()%></td>
         			 <td><%= f.getConN()%></td>
           			

  					 <%
  					 }   
   
  					 %>
  					 
  					 
   					</table>
   
  
   					</form>
		</div>

</div>
</div>
</body>
</html>