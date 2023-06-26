<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/coffee_Milk/css/header.css">
<link rel="stylesheet" href="/coffee_Milk/js/header.js">
</head>
<body>
<header>
<div class="header1">
<a href ="/coffee_Milk/MenuServlet">
<img src="/coffee_Milk/img/logo.png" alt="ペトコレ" id="dog-title">
</a>
<nav class="nav2">
<ul class="header_link">
	<li class="header6"><a href ="/coffee_Milk/MenuServlet">ホーム 🏡</a></li>
	<li class="header6"><a href ="/coffee_Milk/ChatForward">チャット 👪</a></li>
	<li class="header6"><a href ="/coffee_Milk/MyAniBookServlet">Myペット図鑑 📚</a></li>
	<li class="header6">
	ジャンル 👇
		<ul>

			<li><a href ="/coffee_Milk/GenreSearchServlet?genre=dog">犬 🐶</a></li>
			<li><a href ="/coffee_Milk/GenreSearchServlet?genre=cat">猫 🐈</a></li>
			<li><a href ="/coffee_Milk/GenreSearchServlet?genre=small">小動物 🐹</a></li>
			<li><a href ="/coffee_Milk/GenreSearchServlet?genre=aqua">水生生物 🐡</a></li>

		</ul>
	</li>
</ul>
</nav>

<!-- 非ログイン者の場合 -->
<c:if test="${empty id}">
<nav class="nav1">
<ul>
<li><a href ="/coffee_Milk/NewUserServlet" class="header2">新規登録</a></li>
<li><a href ="/coffee_Milk/LoginServlet" class="header2">ログイン</a></li>
</ul>
</nav>
</c:if>
<!-- ログイン者の場合 -->
<c:if test="${!empty id}">
<nav class="nav1">
<ul>
<li><a href ="/coffee_Milk/LogoutServlet" onclick="return kousin()"  class="header2">ログアウト</a></li>
</ul>
</nav>
</c:if>
<!-- キーワード検索を消した <div class="header3">
<input type="text" name="keyword" id="header4">
<input type="submit" name="search" value="検索" id="header5">
</div>-->
</div>
</header>
<script src="/coffee_Milk/js/header.js"></script>
<script type="text/javascript" src="/coffee_Milk/js/jquery-3.7.0.min.js"></script>
</body>
</html>