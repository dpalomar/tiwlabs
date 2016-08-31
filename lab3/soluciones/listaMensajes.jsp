<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
    border-collapse: collapse;
}

table, th,td {
	border: 1px solid;

}
td {
    padding: 15px;
}

</style>
</head>
<body>


	<h1>Lista de mensajes</h1>
	<table>
		<thead>

			<tr>
				<th>De</th>
				<th>Mensaje</th>
			</tr>

		</thead>
		<tbody>
			<c:forEach items="${listaMensajes }" var="mensaje">
				<tr>
					<td>${mensaje.from.nombre }</td>
					<td>${mensaje.mensaje }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="javascript:history.go(-1)">Volver</a>
	</p>
</body>
</html></html>