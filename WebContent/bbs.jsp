<%@page import="BbsList.BbsDTO"%>
<%@page import="java.util.List"%>
<%@page import="BbsList.BbsDAO"%>
<%@page import="BbsList.iBbsList"%>
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
</head>

<style>
	.media:hover{
		border:1px solid black;padding:5px;background-color:#F8F8FF;
	}
	.media:active{
		border:1px solid black;padding:5px;background-color:#B0C4DE;
	}
</style>

<body>
<%!
	// 댓글용 함수
	public String arrow(int depth){	// depth = 0(부모글), depth = 1 ~ (댓글)
		String rs = "<img src='image/arrow.png' width='20px' height='20px'/>";
		String nbsp = "&nbsp;&nbsp;&nbsp;&nbsp;";	// 여백
		
		String ts = "";
		
		for(int i = 0;i < depth; i++){
			ts += nbsp;
		}
		
		return depth==0?"":ts + rs;
	}
%>  
<%
	String id = (String)session.getAttribute("id");
	String pwd = (String)session.getAttribute("pwd");
	if(id == null || id.equals("")){
		%>
		<script type="text/javascript">
			alert("로그인 해 주십시오");
			location.href = "login.jsp";
		</script>	
		<%
		return;
	}
%>

<!-- 검색기능 위치  -->


<a href="bbsinsert.jsp"> 게시글 작성 </a>

<%
	String searchWord = request.getParameter("searchWord");
	String choice = request.getParameter("choice");
	if(choice == null || choice.equals("")){
		choice = "sel";
	}
	
	// 검색어를 지정하지 않고 choice가 넘어 왔을 경우
	if(choice.equals("sel")){
		searchWord = "";
	}
	
	if(searchWord == null){
		searchWord = "";
		choice = "sel";
	}
	
	iBbsList dao = BbsDAO.getInstance();
	List<BbsDTO> list = dao.getBbsList(searchWord, choice);	

	if(list == null || list.size() == 0 ){
%>
	<div class="container mt-3">
	  <div class="media border p-3">
	    <img src="img_avatar3.png" alt="이미지가 없습니다." class="mr-3 mt-3 rounded-circle" style="width:60px;">
	    <div class="media-body">
	      <p><p>
	      <p>작성된 글이 없습니다.</p>
	    </div>
	  </div>
	</div>
<%
	} else {
		for(int i= 0; i < list.size(); i++){
			BbsDTO bbs = list.get(i);
%>
		<div class="container mt-3" >
		 <div class="media border p-3" id="medias" onclick="location.href='bbsSelect.jsp?seq=<%=bbs.getSeq()%>&id=<%=bbs.getId() %>'">
		    <img src="img_avatar3.png" alt="이미지가 없습니다." class="mr-3 mt-3 rounded-circle" style="width:60px;">
		    <h4 class="mr-3 mt-3 rounded-circle"><%= i + 1 %></h4>
		    <div class="media-body">
		      <h4>[<%=bbs.getQatype()%>] <%=bbs.getTitle() %></h4>
		      <p><%=bbs.getContent() %></p>
		      <p>ID : <%=bbs.getId() %>, 작성일 : <%=bbs.getWdate() %>, 조회수 : <%=bbs.getReadcount() %></p>
		    </div>
		  </div>
		</div>
<%
		}
	}
%>





























































</body>
</html>