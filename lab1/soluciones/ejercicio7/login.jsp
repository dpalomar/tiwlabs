<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	.error { color:red;}
</style>
</head>
<body>
<% 
 String nombre = "", password = "";
 if (request.getAttribute("errores") != null){
   Map<String,String> errores = (HashMap<String,String>)request.getAttribute("errores");
	for (int i = 0; i < errores.size(); i++) {
		nombre = errores.get("nombre")!=null?errores.get("nombre"):"";
		password = errores.get("clave")!=null?errores.get("clave"):"";
	}
 }
 if (!nombre.equals("")) { %>
 
 <p class="error"> <%=nombre %> </p>
 
<%	 
 }
%>
 <% if (!password.equals("") ){ %>
 
 <p class="error"><%=password %></p>
 
<%	 
 }
%>
	<h1>Formulario</h1>
	<form action="login" method="post">
		<fieldset>
			<legend>Formulario de login</legend>
			<label for="nom">Nombre:</label> 
			<input type="text" name="nombre" id="nom"><br/> 
			<label for="clave">Password:</label> 
			<input type="password" name="clave" id="clave"><br/>

		</fieldset>
		<input type="submit" value="Enviar">

	</form>
</body>
</html>