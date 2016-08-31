<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="usuario" method="post">
		<fieldset>
			<legend>Alta de Usuarios</legend>

			<label for="nom">Nombre:</label> 
			<input type="text" name="nombre" id="nom" required><br> 
            <label for="apellidos">Apellidos:</label> 
			<input type="text" name="apellidos" id="apellidos"><br>
            <label for="usuario">Usuario:</label> 
			<input type="text" name="usuario" id="usuario"><br>
			<label for="clave">Password:</label> 
			<input type="password" name="password" id="clave">
			<input 	type="hidden" value="ALTA" name="accion">
		</fieldset>
		<input type="submit" value="Enviar">

	</form>
</body>
</html>