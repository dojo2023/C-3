<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ペトコレ|Myペット投稿</title>
</head>

<body>
<h1>ペット投稿フォーム</h1>
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
</body>
</html>