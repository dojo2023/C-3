<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myペット図鑑登録</title>

<!-- スタイルシートの挿入 -->
<link rel="stylesheet" href="/coffee_Milk/css/myaniadd.css">

</head>
<body>

<h1>Myペット図鑑登録</h1>
<div class="flex">
	<p class="image">ペットの写真を載せてください<br>
	<img src="img/うみちゃん.png"><br>
		鳴き声<br>
	鳴き声をどうやって出力するのかわからんけど出力<br></p>
			<p class="main">ペットの名前を入力して下さい<br>
			<input type="text" name="NAME"><br>
			性別<br>
			<input type="radio" name="sex" value="male">オス
			<input type="radio" name="sex" value="female">メス
			<input type="radio" name="sex" value="others">わからない<br>
			誕生日<br>
			<input type="date"><br>
			アピールポイント<br>
			<input type="text" name="POINT"><br>
			<input type="submit" name="REGIST" value="登録">
			</p>
</div>
</body>
</html>