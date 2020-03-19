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
int tt= 0;
for(int i=1;i<=10;++i)
tt+=i;
%>

1~10의 합 : <%=tt %>
</body>
</html>