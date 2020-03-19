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
	int dice = (Integer)request.getAttribute("dice");
	out.println("DICE : " + dice+"<br>");
	for (int i= 0; i<6; ++i){
		out.println("Hello<br>");
	}
%>

</body>
</html>