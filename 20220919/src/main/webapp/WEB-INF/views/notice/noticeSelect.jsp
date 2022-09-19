<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div><jsp:include page="../menu/menu.jsp" /></div>
	<div><h1>게시글 상세보기</h1></div>
	<div>
		${vo.noticeSubject }
	</div>
</div>
</body>
</html>