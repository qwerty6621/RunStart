<%@page import="BbsList.BbsDTO"%>
<%@page import="java.util.List"%>
<%@page import="BbsList.BbsDAO"%>
<%@page import="BbsList.iBbsList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <style>
  @media screen and (min-width:600px) {
  	img {
	  max-width:100%; 
	  width:80px;
	  margin:auto;
	}
   }
   @media screen and (max-width:599px) {
   	img {
	  max-width:100%; 
	  width:60px;
	  margin:auto;
	}
   }
   
   img:hover{
   		border:1px solid white;padding:5px;background-color:white
   }
  
  
  </style>
  
</head>
<body>


<%
	String id = (String)session.getAttribute("id");
	int seq = Integer.parseInt(request.getParameter("seq"));
	iBbsList dao = BbsDAO.getInstance();
	BbsDTO bbs = dao.getBbsSelect(seq);

	
	session.setAttribute("class_m", bbs.getQatype());
	
%>
<!-- =========================================================================================================== -->
<!-- 작성한 사람이면. -->
<form action="bbsUpdate" method="post" enctype="multipart/form-data">
<% if(id.equals(bbs.getId())){ 

%>
	<div class="container mt-3">
		<div class="media border p-3">
			<h4 class="mr-3 mt-3 rounded-circle"></h4>
			  <div class="media-body">
			  <input type="hidden" name="seq" value="<%=bbs.getSeq() %>">
			  <input type="hidden" name="id" value="<%=bbs.getId()%>">
			  	  <p>아이디 : <%=bbs.getId() %></p>
			      <p>제목 : <input type="text" class="textsize" name="title" value="<%=bbs.getTitle()%>">
			      	<select name="qnatype" >
			      		<option value="정형외과" <c:if test="${class_m eq '정형외과'}">selected="selected"</c:if>>정형외과</option>
			      		<option value="치과" <c:if test="${class_m eq '치과'}">selected="selected"</c:if>>치과</option>
			      		<option value="산부인과" <c:if test="${class_m eq '산부인과'}">selected="selected"</c:if>>산부인과</option>
			      		<option value="피부과" <c:if test="${class_m eq '피부과'}">selected="selected"</c:if>>피부과</option>
			      	</select>
			      </p>
			      <p>내용 : <textarea rows="" cols="" class="textsize" name="content"><%=bbs.getContent() %></textarea></p>
			      <hr>
			      <table>
			      	<tr>
			      		<td>
<% 
	String image = bbs.getImage();
	System.out.println(image);
	String images[] = image.split("@");
	int a = 5 - images.length; 
	int b = 0;
	char c[] = images[0].toCharArray();
	System.out.println(c.length);
	
	
	
	
	for(int i=0; i < images.length; i++){
		System.out.println(images.length);
		b++;
		if(c.length == 11){
%>		
			     <img alt="이미지가 없습니다." src="upload\images.png" title="이미지 추가" onclick="javascript:name123<%=b++%>();" >
			     &nbsp;&nbsp;
<% 
		} else {
%>
				<img alt="이미지가 없습니다." src="upload\<%=images[i]%>" title="<%=images[i] %>" onclick="javascript:name123<%=i%>();" >
			     &nbsp;&nbsp;
<%
		}
	} 
	for(int i=0; i < a; i++){
%>
				<img alt="이미지가 없습니다." src="upload\images.png" title="이미지 추가" onclick="javascript:name123<%=b++%>();" >
			     &nbsp;&nbsp;

<%
	}
%>
				 </td>
				 </tr>
				</table>
			      <hr>
			      <p>파일첨부 </p>
			      <hr>
			      <p><input type="submit" class="textsize" value="수정"></p>
			 	     <input type="file" name="fileload1" id="fileload1" onchange="name1230();" hidden="hidden">
					 <input type="file" name="fileload2" id="fileload2" onchange="name1231();" hidden="hidden">
				 	 <input type="file" name="fileload3" id="fileload3" onchange="name1232();" hidden="hidden">
				 	 <input type="file" name="fileload4" id="fileload4" onchange="name1233();" hidden="hidden">
					 <input type="file" name="fileload5" id="fileload5" onchange="name1234();" hidden="hidden">
			  </div>
		</div>
	</div>
</form>
<!-- =========================================================================================================== -->

<!-- =========================================================================================================== -->
<!-- 작성한 사람이 아니면. -->
<%} else {%>
	<div class="container mt-3">
		<div class="media border p-3">
			<h4 class="mr-3 mt-3 rounded-circle"></h4>
			  <div class="media-body">
			  	  <p>작성자 : <%=bbs.getId() %></p>
			      <p>제목 : [<%=bbs.getQatype() %>]  <%=bbs.getTitle()%> </p>
			      <p>내용 : <%=bbs.getContent() %></p>
			      <hr>
<% 
	String image = bbs.getImage();
	System.out.println(image);
	String images[] = image.split("@");
	int a = 0;
	for(int i=0; i < images.length; i++){
		System.out.println(images[i]);
%>
			      <img alt="이미지가 없습니다." src="<%=images[i]%>">&nbsp;&nbsp;
			      <input type="file" name="fileload" hidden="hidden" id="file<%=a++%>">
<% } %>
			      <hr>
			      <p>파일첨부 <input type="file"></p>
			      <hr>
			      <p><input type="submit" class="textsize" value="수정"></p>
			  </div>
		</div>
	</div>

<% } %>


<!-- =========================================================================================================== -->
<form action="" method="post">
	
</form>
<!-- =========================================================================================================== -->


<script type="text/javascript">
	var x = "";
	function name1230(){
		document.getElementById('fileload1').click();
		x = document.getElementById('fileload1').value;
		/* var y = x.split("\\");
		document.getElementById("textCheck0").value = y[2]; */
	}
	function name1231(){
		document.getElementById('fileload2').click();
		x = document.getElementById('fileload2').value;
	}
	function name1232(){
		document.getElementById('fileload3').click();
		x = document.getElementById('fileload3').value;
	}
	function name1233(){
		document.getElementById('fileload4').click();
		x = document.getElementById('fileload4').value;
	}
	function name1234(){
		document.getElementById('fileload5').click();
		x = document.getElementById('fileload5').value;
	}
</script>




























</body>
</html>