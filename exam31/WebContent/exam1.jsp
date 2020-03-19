<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	id =
	<%=getID()%>

	<%!String id = "u001";

	public String getID() {
		return id;
	}%>
	<%-- jsp주석! --%>
	<!-- html 주석! -->
	<%
		/*
		1
		자바주석
		2
		*/
		int i = 5;
		while (i > 0) { //여기도 주석
	%>
	<H <%=i%>> dynamic print!</H<%=i%>>
	<%
		--i;
		}
	%>
</body>
</html>