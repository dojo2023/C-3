<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="header.jsp" %>
<meta charset="UTF-8">
<title>Myペット投稿</title>
<!-- スタイルシートの挿入 -->
<link rel="stylesheet" href="/coffee_Milk/css/anipost.css">
</head>
<body>
<div class="wrapper">
<h1>　　ペット投稿📝</h1>
	<div class="post">
		<form id="anipost_form" method="POST" action="/coffee_Milk/AniPostServlet">
			<input type="hidden" value="${ID}" name="ID">
			<label>〈タイトル〉
				<input type="text" name="TITLE" style="width: 370px; height: 30px; background:#FFFFEF"><br>
			</label>
			<label>〈分類〉<br>
				<input type="radio" name="GENRE" value="犬">犬
				<input type="radio" name="GENRE" value="猫">猫
				<input type="radio" name="GENRE" value="小動物">小動物
				<input type="radio" name="GENRE" value="水生生物">水生生物<br>
			</label>
			<label>〈自由記入欄〉
				<input type="text" name="FREE" placeholder="　　　　　ハッシュタグなどを書いて投稿しよう！" style="width: 370px; height: 30px; background:#FFFFEF"><br>
			</label>
			<label>〈写真〉
				<input type="text" name="PICTURE" style="width: 370px; height: 30px; background:#FFFFEF"><br>
			</label>
			 <input type="submit" name="POST" value="投稿" class="button">
		</form>
	</div>
	<%-- エラーメッセージの表示 --%>
	<c:if test="${not empty error}">
		<p>${error}</p>
	</c:if>
</div>
</body>
</html>