<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editar Usuarios</title>
</head>
<body>
	<form action="usuario" method="post">
		<fieldset>
			<legend>Formulario de Edición de Usuarios</legend>
			<label for="pk">Id:</label> 
			<input type="text" name="id" id="pk" value="${usuario.id }" size="3"   ><br>
			<label for="nom">Nombre:</label> <input type="text" name="nombre"
				id="nom" value="${usuario.nombre }"><br> 
			<label for="apellidos">Apellidos:</label> <input type="text" name="apellidos"
				id="apellidos" value="${usuario.apellidos }"  ><br>
            <label for="usuario">Nick:</label> <input type="text" name="usuario"
				id="usuario" value="${usuario.usuario }"  ><br>
			<label for="clave">Password:</label> <input
				type="password" name="password" id="clave" value="${usuario.password }">
			<input type="hidden" value="EDITAR" name="accion">
		</fieldset>
		<fieldset>
			<legend>Dirección</legend>
			<label for="calle">Calle:</label>
			<input type="text" name="calle" id="calle"/><br/>
			<label for="codigo_postal">CP:</label>
			<input type="number" id="codigo_postal" name="codigo_postal"/><br/>
			<label for="ciudad">Ciudad:</label>
			<input type="text" name="ciudad" id="ciudad" /><br/>
			<label for="pais">País:</label>
			<input type="text" name="pais" id="pais"/><br/>
		</fieldset>
		<input type="submit" value="Enviar">

	</form>

</body>
</html>