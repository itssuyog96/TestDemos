<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.diksha.*" %>


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

List<Account> faclist = AccountDOA.getDataFromAccNo(Integer.parseInt(id));

Iterator<Account> it= faclist.iterator();%>


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
        
        			<td>ACCType</td>
        			<td>Balance</td>
        			
        			
        
   					</tr>
   					<%for (Account f:faclist){
	   				%>
     
          			 <tr><td><%= f.getAcct()%></td>
        
         			 <td><%= f.getBalance()%></td>
           			

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