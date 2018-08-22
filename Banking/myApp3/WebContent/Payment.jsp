<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.diksha.FacilityDOA" %>
<%@ page import="com.diksha.FacilityIn" %> 

<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Didact+Gothic"
	rel="stylesheet" />
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bills</title>

<style type="text/css">

form
{

}

</style>
<script src="jquery-3.3.1.min.js"></script>
<script>
$(document).ready(function(){
	console.log("dfsdf");
	
	$(".btn").click(function(){
		var id = $(this).attr("id").split("_")[0];
		var amount = $("#"+id+"_amount").val();

		if (amount == "")
		{
			alert("Please enter Amount.");
		}
		else
		{
			var form = document.createElement("form");
			form.method="POST";
			form.action = "payment.do";
			
			var ele1 = document.createElement("input");
			ele1.setAttribute("type", "text");
			ele1.setAttribute("name", "amount");
			ele1.setAttribute("value", amount);
			
			var ele2 = document.createElement("input");
			ele2.setAttribute("type", "text");
			ele2.setAttribute("name", "facId");
			ele2.setAttribute("value", id);
			
			form.appendChild(ele1);
			form.appendChild(ele2);
			form.style.display = "none";
			
			$("body").append(form);
			form.submit();
		}
	})
})
</script>
</head>
<body>
<% 

String id=session.getAttribute("AccoNo").toString();

List<FacilityIn> faclist = FacilityDOA.getDataFromAccNo(Integer.parseInt(id));

Iterator<FacilityIn> it= faclist.iterator();
%>
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
		 <form>
					<br><br><br>
					<table align="center" border="2">
   					<tr>
        
        			<td>ACCNO</td>
        			<td>PAYTYPE</td>
        			<td>Provider</td>
        			<td>Consumer Number</td>
        			<td>Amount</td>
        
   					</tr>
   					<%for (FacilityIn f:faclist){
	   				%>
     
          			 <tr><td><%= f.getAccno()%></td>
        
         			 <td><%= f.getPaytype()%></td>
           			<td><%= f.getProvider()%></td>
          			<td><%= f.getConN()%></td>
           			<td><input type="text" name="amount" id="<%=f.getId()%>_amount"/ ></td>
					<td><input type="button" value="Pay" name="submit" id="<%=f.getId()%>_submit" class="btn"/></td></tr>

  					 <%
  					 }   
   
  					 %>
  					 
  					 
   					</table>
   					
   					<a  class ="btn" href="loggedin.html"><button class ="btn"  type="button" >Back</button></a>
  
   					</form>
		</div>

</div>
</div>
</body>
</html>