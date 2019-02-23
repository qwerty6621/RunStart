<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%!
	String id = "";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	id = (String)session.getAttribute("id");
	if(id != null){	
%>		
	<div align="right" >  <h2><%=id%>님 환영합니다. </h2>     </div>   <div align="right"><a href="logout?returns=main.jsp">로그아웃</a></div>
<%
	} else {
%>
	<div align="right" >  <a href="login.jsp">로그인</a> </div>
<%
	}
%>

	<a href="bbs.jsp">게시판</a>

</body>
</html>