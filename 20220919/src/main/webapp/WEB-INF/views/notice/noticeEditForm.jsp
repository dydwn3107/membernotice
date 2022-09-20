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
		
		<div>
			<h1>게시글 수정</h1>
		</div>
		<div>
			<form id="frm" action="noticeEdit.do" method="post" enctype="multipart/form-data">
				<div>
					<table border="1">
						<tr>
							<th width="100">작성자</th>
							<td width="100" align="center">${vo.noticeWriter }</td>
							<th width="100">작성일자</th>
							<td width="100" align="center"><input type="date"
								id="noticeDate" name="noticeDate" value="${vo.noticeDate }">
							</td>
							<th width="100">조회수</th>
							<td width="100" align="center">${vo.noticeHit }</td>
						</tr>
						<tr>
							<th>제목</th>
							<td colspan="5"><input type="text" size="78" id="noticeTitle"
								name="noticeTitle" value="${vo.noticeTitle }"></td>
						</tr>
						<tr>
							<th>내용</th>
							<td colspan="5"><textarea rows="10" cols="80"
									id="noticeSubject" name="noticeSubject">${vo.noticeSubject }</textarea>
							</td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td colspan="5"><input type="file" id="file" name="file"
								value="${vo.noticeAttech }"></td>
						</tr>
					</table>
				</div><br>
				<div>
					<input type="hidden" id="noticeId" name="noticeId" value="${vo.noticeId }">
					<input type="submit" value="수정">&nbsp;&nbsp;
					<input type="button" onclick="location.href='noticeSelectList.do'" value="목록">
				</div>		
			</form>
		</div>
	</div>
</body>
</html>