<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- JSTL 사용 선언 (지시자: 페이지 속성)--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- request scope에 value1을 선언 --%>
<c:set var="value1" scope="request" value="kang" /> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

성 : ${value1}<br> <%-- EL표기법 사용 --%>

<%-- value1 제거  --%>
<c:remove var="value1" scope="request"/>

성: ${value1 }

</body>
</html>