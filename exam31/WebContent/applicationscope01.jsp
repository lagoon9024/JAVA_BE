<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		try {
			int value = (int) application.getAttribute("value"); // application 내장객체사용
			value += 2;
			application.setAttribute("value", value);
	%>
	<h1>value : <%=value%></h1>
	<%-- 표현식 적용 --%>
	<%
		} catch (NullPointerException e) {
	%>
	<h1>value is not defined</h1>
	<%
		}
	%>
</body>
</html>