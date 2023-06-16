<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ペトコレ|チャットスペース</title>
    <link rel="stylesheet" href="/coffee_Milk/css/chat.css">
</head>
<body>
    <h1>ここは犬用チャットページです。</h1>
    <div class="item-wrapper">
        <div class="container">
            <!-- チャット画面を埋め込む -->
            <!--  GETリクエストを送信するURL
            特定のRoom IDに関連するチャットメッセージを表示するためのサーブレットにアクセスできる-->
            <iframe src="/coffee_Milk/MessageServlet?roomid=${param.roomid}" width="650px" height="500px" style="margin: 0 auto;"></iframe>

            <form method="post" action="/coffee_Milk/ChatForward">
                <p>
                    <input type="hidden" name="roomId" value="${param.roomid}"> <!-- RoomIDをhiddenフィールドで送信 -->
                    <input type="text" size="70" name="message" placeholder="メッセージを入力してください。">
                    <input type="submit" value="送信">
                </p>
            </form>

            <form method="get" action="/coffee_Milk/ChatForward">
                <label for="roomSelect">Select Room ID:</label>
                <select id="roomSelect" name="roomid">
                    <option value="1" ${param.roomid == '1' ? 'selected' : ''}>Room 1</option>
                    <option value="2" ${param.roomid == '2' ? 'selected' : ''}>Room 2</option>
                    <option value="3" ${param.roomid == '3' ? 'selected' : ''}>Room 3</option>
                </select>
                <input type="submit" value="Select">
            </form>
        </div>
    </div>
</body>
</html>