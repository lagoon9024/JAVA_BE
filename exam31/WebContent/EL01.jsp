<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
pageContext.setAttribute("p1", "page scope value"); // page scope
request.setAttribute("r1", "request scope value"); // request scope
session.setAttribute("s1", "session scope value"); // session scope
application.setAttribute("a1", "application scope value"); // application scope
%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
pageContext.getAttribute("p1") : <%=pageContext.getAttribute("p1") %><br> <%-- jsp grammer --%>
<br><br>
pageContext.getAttribute("p1") : ${pageScope.p1 }<br> <%-- EL --%>
request.getAttribute("r1") : ${requestScope.r1 }<br>
session.getAttribute("s1") : ${sessionScope.s1 }<br>
application.getAttribute("a1") : ${applicationScope.a1 }<br>
<br><br>
pageContext.getAttribute("p1") : ${p1 }<br> <%-- EL 변수가 겹치지 않을 경우  지금 같이 표기 가능--%>
request.getAttribute("r1") : ${r1 }<br>
session.getAttribute("s1") : ${s1 }<br>
application.getAttribute("a1") : ${a1 }<br>
</body>
</html>