<%@page import="com.zycus.banking.util.Template"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%! String pageId = "all-transactions";  %>
<%! String role = "admin";  %>

<%= Template.getHeader(pageId) %>
<%= Template.getMenu(role, pageId) %>
<!-- MAIN BODY -->

<div class="row">

</div>

<!-- END OF MAIN BODY -->
<%= Template.getFooter() %>
