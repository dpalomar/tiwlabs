<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="mensajes" method="post">
	<fieldset>
		<legend>Esribir mensaje </legend>
		<textarea name="mensaje" id="mensaje" cols="30" rows="10"></textarea>
		<br />
		<input type="submit" value="enviar" />
		<input type="hidden" name="to" value="${param.idTo }" />
		<input type="hidden"  name="from" value="${param.idFrom }"/>
	</fieldset>
</form>
</body>
</html>