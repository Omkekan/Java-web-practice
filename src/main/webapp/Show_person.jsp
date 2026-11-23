<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Person</title>
</head>
	<body>
		<jsp:useBean id="pers" class="example.beans.Person" scope="session"></jsp:useBean>
		<h2>Person Details:</h2>
		<h2>Name: </h2><jsp:getProperty property="name" name="pers"/>
		<h2>Height(cm): </h2><jsp:getProperty property="height" name="pers"/>
		<h2>Weight(kg): </h2><jsp:getProperty property="weight" name="pers"/>
	</body>
</html>