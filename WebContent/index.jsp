<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<% 
	
	String username = session.getAttribute("username").toString();

	if(username == null || username.length() <= 0){
		response.sendRedirect("login.jsp");
	}
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=username%></title>
</head>
<body>
	<h1>Bienvenido a tu panel de control <%=username%>.</h1>
	<form action="startWorkflow" method="POST">
		<input type="text" name="target1" placeholder="Objetivo 1"><br>
		<input type="text" name="target2" placeholder="Objetivo 2"><br>
		<input type="text" name="target3" placeholder="Objetivo 3"><br>
		<input type="text" name="target4" placeholder="Objetivo 4"><br>
		<input type="text" name="target5" placeholder="Objetivo 5"><br>
		<input type="text" name="target6" placeholder="Objetivo 6"><br>
		<input type="text" name="target7" placeholder="Objetivo 7"><br>
		<input type="text" name="target8" placeholder="Objetivo 8"><br>
		<input type="text" name="target9" placeholder="Objetivo 9"><br>
		<label>Hacer unfollow: </label><input type="checkbox" name="unfollow"><br>	
		<label>Perfiles privados: </label><input type="checkbox" name="privatedUsers"><br>	
		<input type="submit" value="Comenzar">
	</form>
</body>
</html>