<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
<script type="text/javascript">
	function check() {		
		var email = document.getElementById("email").value;
		var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
		
			if(exptext.test(email)==false){
			//이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우			
				alert("이 메일형식이 올바르지 않습니다.");
				document.addjoin.email.focus();
				return false;
			}
	}
</script>
</head>
<body>
<h1>방명록</h1>
<c:forEach var="bookData" items="${bookDataList}">
${bookData.email}:
${bookData.text}
${bookData.modifiedDate}
${bookData.modifiedTime}
<a href='modify?no=${bookData.no}'>[수정]</a>
<br>
</c:forEach>
<form action='list' method='post' onsubmit="check();">
이메일 : <input type='text' name='email' id='email'>
암호 : <input type='password' name='password'><br>
내용 : <input type='text' name='text'><br>
<input type='submit' value='추가'>
<input type='reset' value='취소'>
</form>
</body>
</html>