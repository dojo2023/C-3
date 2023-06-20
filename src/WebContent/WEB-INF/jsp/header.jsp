<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/coffee_Milk/css/header.css">
</head>
<body>
<header>
<div class="header1">
<a href ="/coffee_Milk/MenuServlet">
<img src="/coffee_Milk/img/logo.png" alt="ペトコレ">
</a>
<nav class="nav2">
<ul class="header_link">
	<li><a href ="/coffee_Milk/MenuServlet" class="header6">メイン</a></li>
	<li><a href ="/coffee_Milk/ChatForward" class="header6">チャット</a></li>
	<li><a href ="/coffee_Milk/MyAniBookServlet" class="header6">Myペット図鑑</a></li>
	<li id="genre_single">
	<a href ="/coffee_Milk/SearchServlet" class="header6">ジャンル</a>
		<ul>
			<li><a href ="/coffee_Milk/Servlet">犬</a></li>
			<li><a href ="/coffee_Milk/Servlet">猫</a></li>
			<li><a href ="/coffee_Milk/Servlet">小動物</a></li>
			<li><a href ="/coffee_Milk/Servlet">水生生物</a></li>
		</ul>
	</li>
</ul>
</nav>
<nav class="nav1">
<ul>
<li><a href ="/coffee_Milk/NewUserServlet" class="header2">新規登録</a></li>
<li><a href ="/coffee_Milk/LoginServlet" class="header2">ログイン</a></li>
</ul>
</nav>
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