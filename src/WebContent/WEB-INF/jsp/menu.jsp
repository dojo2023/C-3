	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ペトコレ|メニュー</title>
<!-- jsの挿入 -->
<script type="text/javascript" src="/coffee_Milk/js/menu.js"></script>
<!-- スタイルシートの挿入 -->
<link rel="stylesheet" href="/coffee_Milk/css/menu.css">
</head>
<body>
<!-- ヘッダー挿入 -->
<%@ include file="header.jsp" %>
 <h1 style="text-align:center;">ペット投稿一覧</h1>
  <div class="wrapper">
   <div class="sub">
    <form method="POST" action="/coffee_Milk/SearchServlet">
      <p>キーワード検索</p>
        <div class="key">
        <input type="text" size="25" name="keyWord">
          <div class= "search">
            <input type="submit" name="REGIST" value="検索"><br>
          </div>
        </div>
    </form>
 <div class="line">
  <p>並べ替え</p>
   <div class= "beside">
    <form id="posts_list" method="POST" action="/coffee_Milk/PetMenuTimeServlet" onsubmit="return checkPostList();">
      <div class= "botan"><!--データをservletにとばすならtypeはsubmit、JavaScriptならbutton -->
        <input type="submit" name="post" value="投稿順" >
      </div>
    </form>
       <form id="posts_list" method="POST" action="/coffee_Milk/PetListShufffleServlet">
          <input type="submit" name="shuffle" value="シャッフル">
       </form>
    </div>
      <!--  <div class="mouse">
            <input type="submit" name="favorite" value="いいね順">
            <span class="word">
            <input type="submit" name="total" value="総合">
            <input type="submit" name="weekly" value="週別">
            </span>
            </div>-->
   <p>いいねランキング</p>
    <div class ="beside">
    <form id="favorite_id" method="POST" action="/coffee_Milk/PetFavRankServlet">
      <input type="submit" name="favorite" value="総合">
    </form>
    <form id="favorite_id" method="POST" action="/coffee_Milk/PetWeeklyFavRankServlet">
    <input type="submit" name="weekly" value="週別">
    </form>
    </div>
    </div>
    </div>
      <!--<div class="menu_outer01">
            <form id="favorite_id" method="POST" action="/coffee_Milk/PetFavRankServlet">
            <ul class="list">
            <li class="title">いいねランキング</li>
            <li><input type="submit" name="total" value="総合"></li>
            <li><input type="submit" name="weekly" value="週別"></li>
            </ul>
            </form>
            </div>-->
<section>
<c:if test="${empty PetList}">
   <p>一致するデータはありません。</p>
</c:if>
<c:forEach var="e" items="${PetList}" >
  <table class = petpost>
      <tr>
        <td style="font-size:20px; border-bottom: solid darkgreen thin; " ><c:out value="${e.title}"></c:out></td>
      </tr>
      <tr>
	    <td><c:out value="${e.genre}"></c:out></td>
      </tr>
      <tr>
        <td><c:out value="${e.free}"></c:out></td>
      </tr>
      <tr>
         <td class= "photo">
         	<img src="<c:out value="${e.picture}"></c:out>">
         </td>
      </tr>
      <tr>
         <td>
           <form method="POST" id="favorite" action="/coffee_Milk/FavoriteServlet">
          <!-- changeColor呼び出し hiddenにより最初は赤ハートが非表示になる-->
             <div class="heart" onclick="changeColor(this)">
          	   <input type="hidden" name="posts_id" value="${e.picture_books_id}">
                   <img src="/coffee_Milk/img/heart.png" alt="いいね！"  width="30" height="25"class="white-heart" name="favorite">
                   <img src="/coffee_Milk/img/redheart.png" alt="いいね！" width="30" height="25" class="red-heart hidden">
             </div>
           </form>
         </td>
      </tr>
      <tr>
        <td>
          <a href ="/coffee_Milk/MyAniBookServlet?pbi=<c:out value="${e.picture_books_id}"></c:out>">図鑑を見る
          </a>
        </td>
      </tr>
  </table>
</c:forEach>
</section>
</div>
  <!-- マウスカーソルを合わせると文字が出てくる -->
  <span class="word">
    <input type="submit" name="total" value="総合">
    <input type="submit" name="weekly" value="週別">
  </span>
  <!--ページ番号 -->
  <div class ="page">
  	<a href="/coffee_Milk/PageServlet?page=1">1</a>
    <a href="/coffee_Milk/PageServlet?page=2">2</a>
    <a href="/coffee_Milk/PageServlet?page=3">3</a>
    <a href="/coffee_Milk/PageServlet?page=4">4</a>
  </div>
</div>
  <!--図鑑を見るをクリックするとMyaniBookServletにとぶ
<p><a href="/coffee_Milk/MyAniBookServlet">図鑑を見る</a></p>-->
</body>
</html>
