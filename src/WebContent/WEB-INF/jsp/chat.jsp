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
    <script type="text/javascript" src="/coffee_Milk/js/chat.js"></script>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="chat-center">
<!--  ルームIDが空だったら-->
<c:choose>
<c:when test = "${empty param.roomid}">
	<h1>チャット欄へようこそ</h1>
</c:when>

	<c:otherwise>
		<c:if test ="${param.roomid == '1'}">
    		<h1>犬チャット欄 <img src="/coffee_Milk/img/dog_akitainu.png" alt="イヌ"></h1>
		</c:if>

		<c:if test ="${param.roomid == '2'}">
			<h1>猫チャット欄 <img src="/coffee_Milk/img/cat06_moyou_chatora.png" alt="ネコ"></h1>
		</c:if>

		<c:if test = "${param.roomid == '3'}">
			<h1>水生動物チャット欄 <img src="/coffee_Milk/img/fish_kingyo2.png" alt="水生動物"></h1>
		</c:if>

		<c:if test = "${param.roomid == '4'}">
			<h1>小動物チャット欄 <img src="/coffee_Milk/img/animal_hamster.png" alt="小動物"></h1>
		</c:if>
	</c:otherwise>
</c:choose>
※10秒ごとに更新されます※

    <div class="item-wrapper">
        <div class="container">
        <!-- ルームIDが選択されていなかった場合 -->
        <c:if test = "${empty param.roomid}">
        <h1>ルームを選択してください</h1>
        </c:if>
        <c:if test = "${!empty param.roomid}">
            <!-- チャット画面を埋め込む -->
            <!--  GETリクエストを送信するURL
            特定のRoom IDに関連するチャットメッセージを表示するためのサーブレットにアクセスできる-->
            <iframe src="/coffee_Milk/MessageServlet?roomid=${param.roomid}" width="650px" height="500px" style="margin: 0 auto; background-color:white;"></iframe>
		</c:if>

            <form id="messageForm" method="post" action="/coffee_Milk/MessageServlet?roomid=${param.roomid}" onsubmit="return SubmitNGWords()">

<p>
           <c:if test = "${!empty param.roomid}">
       		 <c:choose>
                		<c:when test="${param.roomid == '1'}">
                            <input id="nickname" type="text" size="20" name="nickname" placeholder="ニックネームを入力" value="${empty param.nickname ? '匿名犬' : param.nickname}"><br>
                        </c:when>

                        <c:when test="${param.roomid == '2'}">
                            <input id="nickname" type="text" size="20" name="nickname" placeholder="ニックネームを入力" value="${empty param.nickname ? '匿名猫' : param.nickname}"><br>
                        </c:when>

                        <c:when test="${param.roomid == '3'}">
                            <input id="nickname" type="text" size="20" name="nickname" placeholder="ニックネームを入力" value="${empty param.nickname ? '匿名水生動物' : param.nickname}"><br>
                        </c:when>

                        <c:when test="${param.roomid == '4'}">
                            <input id="nickname" type="text" size="20" name="nickname" placeholder="ニックネームを入力" value="${empty param.nickname ? '匿名小動物' : param.nickname}"><br>
                        </c:when>

                        <c:otherwise>
                            <input id="nickname" type="text" size="20" name="nickname" placeholder="ニックネームを入力" value="${empty param.nickname ? 'ゲスト' : param.nickname}"><br>
                        </c:otherwise>
         	</c:choose>
                <input id="message" type="text" size="70" name="message" placeholder="メッセージを入力"required>
             	<input type="submit" value="送信" >
          </c:if>
                    <input type="hidden" name="roomId" value="${param.roomid}"> <!-- RoomIDをhiddenフィールドで送信 -->
</p>
            </form>
            <form method="get" action="/coffee_Milk/ChatForward">
                <label for="roomSelect">ルームを選択してください:</label>
                <select id="roomSelect" name="roomid">
                    <option value="1" ${param.roomid == '1' ? 'selected' : ''}>犬</option>
                    <option value="2" ${param.roomid == '2' ? 'selected' : ''}>猫</option>
                    <option value="3" ${param.roomid == '3' ? 'selected' : ''}>水生動物</option>
                    <option value="4" ${param.roomid == '4' ? 'selected' : ''}>小動物</option>
                </select>
                <input type="submit" value="選択">
            </form>
        </div>
      </div>
    </div>
</body>
</html>