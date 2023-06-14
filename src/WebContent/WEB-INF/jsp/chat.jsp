<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- ルームIDを取得 -->
    <%String roomid =(String) request.getAttribute("roomid");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ペトコレ|チャット</title>
<link rel="stylesheet" href="/coffee_Milk/css/chat.css">
</head>
<body>
<h1>ここは犬用チャットページです。</h1>
<div class="item-wrapper">
	<div class="container">
<!-- チャット画面を埋め込む -->
<iframe src="message.jsp"width="650px"height="500px margin:0 auto;"></iframe>
	<form method="post" action="<%=request.getContextPath()%>/message?roomid=<%=roomid%>&cmd=1">
		<p>
		<input type=text size="70" name="message" placeholder="メッセージを入力してください。"></input>
		<input type="submit" value="送信"></input>
		</p>
	</form>
	</div>
</div>
</body>
</html>