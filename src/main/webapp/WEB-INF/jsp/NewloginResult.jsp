<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.User" %>
<% 
	User loginUser = (User)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶ会員登録完了</h1>
<% if(loginUser != null){ %>
	<p>会員登録完了しました</p>
	<p>ようこそ<%= loginUser.getName() %>さん</p>
	<a href="Main">つぶやき投稿・閲覧へ</a>
	<%}else{ %>
	<p>会員登録に失敗しました。もう一度やり直してください</p>
	<a href="Main">TOPへ</a>
	<% }%>
</body>
</html>