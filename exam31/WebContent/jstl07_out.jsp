<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="t" value="<script type='text/javascript'>alert(1);</script>" />
${t }<%-- 미출력 --%>

<%-- escapeXml이 true일 경우 <,>,&,'," 문자는 변환되어 출력된다, false의 경우에는 string이 아닌 구문으로 인식해 출력되지 않는다 --%>
<c:out value="${t }" escapeXml="true"/> <%-- 출력 --%>
<c:out value="${t }" escapeXml="false"/> <%-- 미출력 --%>

</body>
</html>