<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
  <script src="js/memberinsert.js" type="text/javascript"></script>
</head>
<body>
<h2>회원가입</h2>


<div align="center">
	<form action="memberinsert">
		<table border="1">
			<tr>
				<td>ID</td> <td><input type="text" name="id" id="_id" title="아이디를 입력해주세요" required/> <button type="button" id="chk">중복체크</button></td>
			</tr>
			<tr>
				<td>pwd</td> <td><input type="text" name="pwd" title="비밀번호를 입력해주세요" required/></td>
			</tr>
			<tr>
				<td>name</td> <td><input type="text" name="name" title="이름을 입력해주세요" required/></td>
			</tr>
			<tr>
				<td>email</td> <td><input type="email" name="email" title="이메일을 입력해주세요" required/></td>
			</tr>
			<tr>
				<td>phone</td> <td><input type="text" name="phone"  pattern="[0-9]{11}"  title="전화번호를 입력해주세요(숫자만)" required/></td>
			</tr>
			<tr>
				<td>GENDER</td> <td> 남자 <input type="radio" name="gender" value="남자" checked="checked" title="성별 체크를 해주세요" required/> 여자 <input type="radio" name="gender" value="여자"></td>
			</tr>
			<tr>
				<!-- <td>AGE</td> <td><input type="date" name="age" min="1945-01-01" max="2024-12-31" title="나이를 입력해주세요" required/><br></td> -->
				<td>age</td> <td><input type="number" name="age" min="0" max="100" title="나이를 입력해주세요" required="required"> </td>
			</tr>
			<tr>
				<td>ADDRESS</td> <td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td>ETC</td> <td><textarea rows="10" cols="50" NAME="etc"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="회원가입"></td>
			</tr>
		</table>
	
	</form>
</div>


</body>
</html>