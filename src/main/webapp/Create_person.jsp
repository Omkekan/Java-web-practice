<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Person</title>
</head>
	<body>
		<jsp:useBean id="pers" class="example.beans.Person" scope="session"></jsp:useBean>
		<jsp:setProperty property="*" name="pers"/>
		<h1>
		Person Created, To view please <a href="Show_person.jsp">click here.</a>
		</h1>
	</body>
</html>