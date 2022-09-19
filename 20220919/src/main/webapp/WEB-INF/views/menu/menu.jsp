<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/menu.css">
</head>
<body>
	<nav id="topMenu">
		<ul>
			<li><a class="menuLink" href="main.do">Home</a></li>
			<li><a class="menuLink" href="noticeSelectList.do">Notice</a></li>
			<li><a class="menuLink" href="#">Join</a></li>
			<li><a class="menuLink" href="#">Member</a></li>
			<li><a class="menuLink" href="#">Content</a></li>
			<c:choose>
				<c:when test="${empty id }">
					<li><a class="menuLink" href="memberLoginForm.do">Login</a></li>
				</c:when>
				<c:otherwise>
					<li><a class="menuLink" href="memberLogout.do">Logout</a></li>
					<li>${name}님 환영합니다.</li>
				</c:otherwise>
			</c:choose>
			
		</ul>
	</nav>
</body>
</html>