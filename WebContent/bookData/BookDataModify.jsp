<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
<h1>게시글 수정</h1>
<form action='modify' method='post'>
이메일 : <input type='text' name='email' value='${bookData.email}' readonly>
비밀번호 : <input type='text' name='password'><br>
내용 : <input type='text' name='text' value='${bookData.text}'>
<input type='submit' value='저장'>
<input type='reset' value='삭제'>
</form>
</body>
</html>