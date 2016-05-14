<%@page import="br.com.fabricadeprogramador.model.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form method="post" action="cliente">
		Name: 
		<input type="text" value="" name="email"/> 
		<input type="submit" value="Save">
	</form>
	
	<% 
		List<Cliente> clientes = (List<Cliente>)request.getAttribute("clientes");
		
	   for(Cliente cliente : clientes){
		   out.print(cliente.getEmail()+ "<br/>");
	   }
	
	%>
</body>
</html>