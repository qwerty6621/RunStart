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
	String aaa = request.getParameter("aaa");

	if(aaa.equals("true")){
%>
	<script type="text/javascript">
		alert("회원가입 성공");
		location.href="../login.jsp";
	</script>
<%
	} else {
%>
	<script type="text/javascript">
		alert("회원가입 실패");
		location.href="../userinfo.jsp";
	</script>
<%
	}
%>
</body>
</html>