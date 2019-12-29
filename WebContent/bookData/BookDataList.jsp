<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
</head>
<body>
<h1>방명록</h1>
<c:forEach var="bookData" items="${bookDataList}">
${bookData.no}.  
${bookData.email}:
${bookData.text}<br>
</c:forEach>
<form action='list' method='post'>
이메일 : <input type='text' name='email'>
암호 : <input type='password' name='password'><br>
내용 : <input type='text' name='g_text'><br>
<input type='submit' value='추가'>
<input type='reset' value='취소'>
</form>
</body>
</html>