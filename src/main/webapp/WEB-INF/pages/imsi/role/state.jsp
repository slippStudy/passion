<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>임시 페이지</title>
</head>
<body>
<section>
	<h1>임시로 사용자의 롤을 지정합니다.</h1>
	<span>현재 사용자의 롤은 ${USER_ROLE} 입니다.</span>
</section>
<form action="${pageContext.request.contextPath}/imsi/role/state" method="POST">
	<fieldset>
		<label>ROLE </label>
		<select name="role"> 
			<option value="ADMIN">관리자</option>
			<option value="GENERAL">일반</option>
		</select>
		<input type="submit" >
	</fieldset>
	
</form>

</body>
</html>