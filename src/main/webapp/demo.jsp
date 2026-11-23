<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate, java.time.LocalTime" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>demp jsp</title>
</head>
	<body>
		<%-- Declaring a variable and defining some method--%>
		<%!
		int num = 7;
		public String saywelcome(String name){
			return "welcome "+ name;
		}
		%>
		
		<h2>Num = <%= num %></h2>
		<h2>Square of <%= num %>is <%=(num*num) %>.</h2>
		<h2>is <%=num %> &lt; 9?<%=(num<9) %></h2>
		<h2>This method is saying <%= saywelcome("Jack") %></h2>
		
		<%--printing hello in h1 tag 5 times. --%>
		<%
		for(int i =0; i<=5; i++){
		%>
		<h2>Hello</h2>
		<%
		}
		%>
		
		<%-- date and time --%>
		<%
		LocalDate today = LocalDate.now();
		LocalTime now = LocalTime.now();
		%>
		
		<h2> Today's date is <%= today %></h2>
		<h2> Todays's time is <%= now %></h2>
		
	</body>
</html>