<%@page import="BbsList.BbsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
  <script src="js/jquery.MultiFile.js" type="text/javascript"></script>
  <link rel="stylesheet" href="jquery.MultiFile.css">
</head>
<style>
	.textsize{ width:100% }
</style>
<body>

<%
	String id = (String)session.getAttribute("id");
  // 세션이 없는경우 로그인 페이지로 보내는 소스 작성 필요
%>


<h2>게시물 작성</h2>

<form action="bbsInsert" method="post" enctype="multipart/form-data">
	<div class="container mt-3">
		<div class="media border p-3">
			<h4 class="mr-3 mt-3 rounded-circle"></h4>
			  <div class="media-body">
			  <input type="hidden" name="id" value="<%=id%>">
			  	  <p>아이디 : <%=id %></p>
			      <p>제목 : <input type="text" class="textsize" name="title"><p>
			      	<select name="qnatype" >
			      		<option value="정형외과">정형외과</option>
			      		<option value="치과">치과</option>
			      		<option value="산부인과">산부인과</option>
			      		<option value="피부과">피부과</option>
			      	</select> 
			      
			      <p>내용 : <textarea rows="" cols="" class="textsize" name="content"></textarea></p>
			      <hr>
			      <p><img alt="이미지가 없습니다." src="#"></p>
			      <hr>
			      <p>
			      <label class="btn btn-primary btn-file ">
    				    파일추가 <input type="file" class="multi" multiple="multiple" style="display: none;" accept="gif|jpg|png" maxlength="5" name="fileload">
				  </label>
				  
				  
				  </p>
			      <hr>
			      <p><input type="submit" class="textsize" id="btn" ></p>
			  </div>
		</div>
	</div>
</form>


<script type="text/javascript">
    $(function(){
        $("#btn").click(function(){
            location.href="bbsInsert?fileload=" + $('#file').val();
        });
    });
</script>
</body>
</html>