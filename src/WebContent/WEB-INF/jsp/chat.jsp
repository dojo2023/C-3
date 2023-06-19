<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <script src="js/header.js"></script>
    <meta charset="UTF-8">
    <title>ペトコレ|チャットスペース</title>
    <link rel="stylesheet" href="/coffee_Milk/css/chat.css">
    <link rel="stylesheet" href="/coffee_Milk/css/header.css">
</head>
<body>
<%@ include file="header.jsp" %>
<!--  ルームIDが空だったら-->
<c:choose>
<c:when test = "${empty param.roomid}">
<h1>チャット欄へようこそ</h1>
</c:when>
<c:otherwise>
<c:if test ="${param.roomid == '1'}">
    <h1>犬チャット欄</h1>
</c:if>
<c:if test ="${param.roomid == '2'}">
<h1>猫チャット欄</h1>
</c:if>
<c:if test = "${param.roomid == '3'}">
<h1>水生動物チャット欄</h1>
</c:if>
<c:if test = "${param.roomid == '4'}">
<h1>小動物チャット欄</h1>
</c:if>
</c:otherwise>
</c:choose>
    <div class="item-wrapper">
        <div class="container">
        <!-- ルームIDが選択されていなかった場合 -->
        <c:if test = "${empty param.roomid}">
        <h1>ルームIDを選択してください</h1>
        </c:if>
        <c:if test = "${!empty param.roomid}">
            <!-- チャット画面を埋め込む -->
            <!--  GETリクエストを送信するURL
            特定のRoom IDに関連するチャットメッセージを表示するためのサーブレットにアクセスできる-->
            <iframe src="/coffee_Milk/MessageServlet?roomid=${param.roomid}" width="650px" height="500px" style="margin: 0 auto;"></iframe>
		</c:if>
            <form method="post" action="/coffee_Milk/ChatForward">
                <p>
                 <c:if test = "${!empty param.roomid}">
               	<input type ="text" size="20" name ="nickname"placeholder="ニックネームを入力" value="${empty param.nickname ? 'ゲスト' : param.nickname}">
                <input type="text" size="70" name="message" placeholder="メッセージを入力">
             <input type="submit" value="送信">
              </c:if>
                    <input type="hidden" name="roomId" value="${param.roomid}"> <!-- RoomIDをhiddenフィールドで送信 -->
                </p>
            </form>
            <form method="get" action="/coffee_Milk/ChatForward">
                <label for="roomSelect">Select Room ID:</label>
                <select id="roomSelect" name="roomid">
                    <option value="1" ${param.roomid == '1' ? 'selected' : ''}>犬</option>
                    <option value="2" ${param.roomid == '2' ? 'selected' : ''}>猫</option>
                    <option value="3" ${param.roomid == '3' ? 'selected' : ''}>水生動物</option>
                    <option value="4" ${param.roomid == '4' ? 'selected' : ''}>小動物</option>
                </select>
                <input type="submit" value="Select">
            </form>
        </div>
    </div>
</body>
</html>