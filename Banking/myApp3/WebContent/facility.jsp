<%@ page import="com.diksha.AccountDOA" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Didact+Gothic"
	rel="stylesheet" />
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />
<meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">

<style>
 body
{
background-size: 1500px 1500px;
background-repeat:no-repeat;
background-image:url("images/img.jpg");
 margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}
div{
 
 margin-left:400px;
 margin-right:400px;
 
 border-style: solid;
 align:centre;
 }
input[type=text] {

	align:centre;
    width: 230px;
    box-sizing: border-box;
    
    border: 2px solid #ccc;
    border-radius: 4px;
    font-size: 16px;
    background-color: white;
    
    background-position: 10px 10px; 
    background-repeat: no-repeat;
    padding: 12px 20px 12px 40px;
    -webkit-transition: width 0.4s ease-in-out;
    transition: width 0.4s ease-in-out;
}
.submit
{
margin-left: 200px;
padding: 10px 20px;

}
.btn
{
margin-left: 10px;
padding: 10px 20px;
}
input[type=text]:focus {
    width: 100%;
}
#electric_select{
	display: none;
}
#phone_select{
	display: none;
} 
form{
background-color:grey;}
 </style>
<title>Insert title here</title>
<script>
window.onload=function(){
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "get-account-no.do");
	
	xhr.onreadystatechange = function()
	{
		var DONE = 4;
		var OK = 200;
		
		if (xhr.readyState == DONE)
		{
			if (xhr.status == OK)
			{
				var accSpan = document.getElementById("acc_no");
				accSpan.innerHTML = xhr.responseText;
			}
			else
			{
				console.log(xhr.status);
			}
		}
	}
	
	xhr.send();
}
</script>
</head>
<body>

<h1 style="background-color:grey;"  input align="center"  >Bank Forms</h1>
<br><br><br><br><br><br>
<div id="menu">
<form input align="center" action="facility.do" method="post" >
<br><br><br><br><br><br>

<p><b>Account Number: <%= AccountDOA.getIdFromCustID((Integer)session.getAttribute("cust_id")) %></p>

<input type="radio" name="title1" id="ele_radio">Electric Bill
  <input type="radio" name="title2" id="phone_radio">Phone Bill
  <select name="Electric_Bill" id="electric_select">
  	<option value="SELECT">SELECT</option>
    <option value="MSEB">MSEB</option>
    <option value="TATA">TATA</option>
    <option value="RELIANCE">RELIANCE</option>
      </select>


  
 <select name="Phone_Bill" id="phone_select">
  	<option value="SELECT">SELECT</option>
    <option value="MTNL">MTNL</option>
    <option value="JIO">JIO</option>
    <option value="AIRTEL">AIRTEL</option>
    <option value="VODAFONE">VODAFONE</option>
    <option value="IDEA">IDEA</option>
  </select>
  
  
  
  
  <br><br><br><br>
  ConsumerNumber:
  <input type="text" name="ConsumerNo">
  <br><br>
  <a  class ="btn" href="http://localhost:8080/myApp3/Index1.html"><button class ="btn"  type="button" >Done</button></a>
  <input  class="submit" type="submit" value="Submit" >
  <br><br><br><br><br><br>
</form>
</div>
<script>

var eleRadio = document.getElementById("ele_radio");
var phoneRadio = document.getElementById("phone_radio");

eleRadio.checked = false;
phoneRadio.checked = false;

var eleSelect = document.getElementById("electric_select");
var phoneSelect = document.getElementById("phone_select");

eleRadio.addEventListener("click", function(){
	if (eleRadio.checked)
	{
		eleSelect.style.display = "block";
		phoneSelect.style.display = "none";
	}
}, false);

phoneRadio.addEventListener("click", function(){
	eleSelect.style.display = "none";
	phoneSelect.style.display = "block";
}, false);

</script>

</body>
</html>