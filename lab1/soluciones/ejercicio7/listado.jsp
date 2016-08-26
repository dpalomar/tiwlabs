<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		Hola
		<%=request.getParameter("nombre")%>
	</h1>
	<p>
		Tu clave es:
		<%=request.getParameter("clave")%>
	</p>
	<table>
		<tr>
			<th>Nombre</th>
		</tr>
	<%
		List<String> listaUsuarios = (ArrayList) request.getAttribute("usuarios");
		for (String nombre : listaUsuarios) { 
	%>
		<tr>
			<td><%=nombre%></td>
		</tr>
   <%
   }
	%>


	</table>
</body>
</html>