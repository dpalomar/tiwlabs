<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Formulario</h1>
	<form action="formulario" method="post">
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