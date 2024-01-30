<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 선언문 -->
<%!
	String name = "여다영";
	String getName() {
		return name;
	}
%>
<!-- 스크립틀릿 -->
<%
	String age = request.getParameter("age");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 스크립트 요소</title>
</head>
<body>
<!-- 표현식 -->
	<h1>안녕하세요 <%=name %>님!!</h1>
	<h1>나이는 <%=age %>입니다!!</h1>
	<h1>키는 <%=180 %>cm입니다!!</h1>
	<h1>나이+10은 <%=Integer.parseInt(age) + 10 %>살입니다!!</h1>
</body>
</html>