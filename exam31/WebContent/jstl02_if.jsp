<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- JSTL 사용 선언 (지시자: 페이지 속성)--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- request scope에 n을 10으로 선언 --%>
<% request.setAttribute("n", 10); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${n==0 }">
n은 0과 같습니다.
</c:if>

<c:if test="${n==10 }">
n은 10과 같습니다.
</c:if>

</body>
</html>