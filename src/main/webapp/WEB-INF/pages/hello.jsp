<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

	<h1>임시 작업 컨테이너 입니다. </h1>
	
	<dl>
	  <dt>  현재 세션에 대한 롤 파악 및 변경 </dt>  
	  <dd>  <a href="${pageContext.request.contextPath}/imsi/role/state">롤 변경 </a></dd>
      <dt>  Admin </dt>
      <dd>  <a href="${pageContext.request.contextPath}/admin">관리자페이지 이동 </a></dd>        
      <dd>  <a href="${pageContext.request.contextPath}/imsi/sign/sign">로그인 페이지로 이동 </a></dd>	
    </dl>

</body>
</html>