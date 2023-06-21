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
<h1>ペット投稿フォーム</h1>
	<div class="post">
		<div class="secret">
			<c:out value="${ID}" />
		</div>
		<label>タイトル
			<input type="text" name="TITLE"><br>
		</label>
		<label>分類
			<input type="radio" name="classification" value="dog">犬
			<input type="radio" name="classification" value="cat">猫
			<input type="radio" name="classification" value="smallanimals">小動物
			<input type="radio" name="classification" value="aquaticlife">水生生物<br>
		</label>
		<label>自由記入欄
			<input type="text" name="FREE" placeholder="(ハッシュタグなどを書いて投稿しよう！)" /><br>
		</label>
		<label>写真　　　
			<input type="text" name="FREE"><br>
		</label>
		 <input type="submit" name="POST" value="投稿">
	 </div>
</div>
</body>
</html>