<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
	<table border="1" width="500">
	<c:forEach var="board" items="${list}">
		<tr>
			<td>${board.comm_type} ${board.comm_pet_type} ${board.comm_breed}</td>
			<td rowspan="4"><img src="/upload/community/${board.comm_img}" width="100" height="100"></td>
		</tr>
		<tr>
			<td>${board.comm_title}</td>
		</tr>
		<tr>
			<td>${board.comm_content}</td>
		</tr>
		<tr>
			<td>답변${board.comm_count} ${board.comm_writer} ${board.comm_tag}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>