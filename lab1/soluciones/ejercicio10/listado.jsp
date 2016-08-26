<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.error{color:red;}
</style>
</head>
<body>
<h1>Hola</h1>
<h2>Tu nombre es: ${sessionScope.usuario.nombre}</h2> <!-- Esto saca el objeto usuario almacenado en la sesion por el LoginServlet y accede a su propiedad nombre -->
<h2>tu clave es: ${param.password }</h2> <!-- Esto saca el parametro pasado por el usuario y recogido dentro del objeto request -->
<c:if test="${empty param.password }">
<p class="error">Si ves el nombre de usuario pero no la password es porque el nombre esta almacenado en session, mientras que la password en request.</p>
</c:if>
<h3>Aqui tienes el listado de usuarios</h3>
<c:if test="${empty usuarios }"> <!-- usuarios es un atributo metido en el request por eso no es necesario ponerle el prefijo param -->
<p class="error">Si no ves usuarios es porque has accedido directamente a la pagina y por tanto no has pasado
por el servlet controlador y no hay datos en el objeto request.
</p>
</c:if>
<table border="1">
<tr>
<th>Nombre</th>
<th>Apellidos</th>
</tr>
<c:forEach items="${usuarios }" var="usuario"> <!-- recorremos todos los objetos de la coleccion usuarios y cada objeto devuelto lo asignamos a la variable usuario -->
<tr>
	<td>${usuario.nombre }</td> <!-- Usuario es un POJO por lo que podemos acceder a sus propiedades sin necesidad de get/set -->
	<td>${usuario.apellidos }</td>
</tr>

</c:forEach>
</table>
<p><a href="login.jsp">Volver</a></p>
</body>
</html>