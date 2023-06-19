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
<!--ポップアップウィンドウの表示-->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.7.1/css/lightbox.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.7.1/js/lightbox.min.js" type="text/javascript"></script>
</head>
<body>
  <div class="wrapper">
    <p>キーワード検索</p>
       <input type="text" size="30" name="keyword">
<h1>ペット投稿一覧</h1>
  <p>並べ替え</p>
    <form id="posts_list" method="POST" action="/coffee_Milk/SearchServlet" onsubmit="return checkPostList();">
      <div class= "botan"><!--データをservletにとばすならtypeはsubmit、JavaScriptならbutton -->
        <input type="submit" name="post" value="投稿順" >
        <input type="submit" name="shuffle" value="シャッフル">
      <!--  <div class="mouse">
       <input type="submit" name="favorite" value="いいね順">
         <span class="word">
          <input type="submit" name="total" value="総合">
          <input type="submit" name="weekly" value="週別">
         </span>
      </div>-->
        <div class="menu_outer01">
          <ul class="list">
            <li class="title">いいねランキング</li>
            <li><input type="submit" name="total" value="総合"></li>
            <li><input type="submit" name="weekly" value="週別"></li>
          </ul>
        </div>
      </div>
    </form>
<c:forEach var="e" items="${petList}" >

  <table class = petpost>
    <form method="POST" id="pop" action="/coffee_Milk/SearchServlet" class="kekka" onsubmit= "return checkKekka();">
      <tr>
        <td><a href="/coffee_Milk/img/dog.jpeg" data-lightbox="group"><img src="/coffee_Milk/img/dog.jpeg" width="200px" height="180px"></a></td><%-- e.はスコープから取り出したときの名前--%>
      </tr>
      <tr>
        <td>タイトル</td>
      </tr>
      <tr>
	    <td>ハッシュタグ</td>
      </tr>
      <tr>
        <td>
          <!-- changeColor呼び出し hiddenにより最初は赤ハートが非表示になる 、ハートの周りを押しても色が変わるため修正必要-->
          <div class="heart" onclick="changeColor(this)" >
            <img src="/coffee_Milk/img/heart.png" alt="いいね！" width="30" height="25" class="white-heart">
            <img src="/coffee_Milk/img/redheart.png" alt="いいね！" width="30" height="25" class="red-heart hidden">
          </div>
        </td>
      </tr>
      <tr>
        <td><a href ="/coffee_Milk/MyAniBookServlet">図鑑を見る</a></td>
      </tr>
    </form>
  </table>
</c:forEach>
</div>
  <!-- マウスカーソルを合わせると文字が出てくる -->
  <span class="word">
    <input type="submit" name="total" value="総合">
    <input type="submit" name="weekly" value="週別">
  </span>


<!-- ページ番号-->
<div class="num">
<%
//ページ数・現在ページの変数宣言
int currentPage;
int lastPageNum;
//変数代入、データの数÷１ページに表示する投稿の数を代入できるようにする
currentPage = 1;
lastPageNum = 9;
//定数宣言
final int FIRST_PAGE = 1;
final int FIRST_HALF_CHECK = 5;
final int LAST_HALF_CHECK = 4;
final int BEFORE_AND_AFTER = 2;
%>
<section>
  <div class="pageLeft">
    <%if(currentPage != FIRST_PAGE){ %>
      <a href="">前のページ</a>
    <%} %>
  </div>
  <div class="pageCenter">
    <%if(currentPage >= FIRST_HALF_CHECK){ %>
      <a href="">1</a>
…
    <%} %>
    <%if(currentPage < FIRST_HALF_CHECK){ %>
      <%for(int i = 1; i <= FIRST_HALF_CHECK; i++){ %>
        <%if(i <= lastPageNum){ %>
        <!-- aタグを入れるか入れないかの分岐（現在ページにaタグは入れない）-->
            <%if(i == currentPage){ %>
                <span><%=i %></span>
            <%}else{ %>
                <a href=""><%=i %></a>
            <%} %>
        <%} %>
      <%} %>
    <%}else if(lastPageNum - currentPage < LAST_HALF_CHECK){ %>
      <%for(int i = lastPageNum - LAST_HALF_CHECK; i <= lastPageNum; i++){ %>
        <%if(i > 0){ %>
        <!-- aタグを入れるか入れないかの分岐（現在ページにaタグは入れない）-->
            <%if(i == currentPage){ %>
                <span><%=i %></span>
            <%}else{ %>
                <a href=""><%=i %></a>
            <%} %>
        <%} %>
    <%} %>
            <%}else{ %>
      <%for(int i = currentPage - BEFORE_AND_AFTER; i <= currentPage + BEFORE_AND_AFTER; i++){ %>
        <!--  aタグを入れるか入れないかの分岐（現在ページにaタグは入れない）-->
            <%if(i == currentPage){ %>
                <span><%=i %></span>
            <%}else{ %>
                <a href=""><%=i %></a>
            <%} %>
      <%} %>
<%} %>
    <%if(lastPageNum - currentPage >= LAST_HALF_CHECK){ %>
      …<a href=""><%=lastPageNum %></a>
    <%} %>
</div>
<div class="pageRight">
<%if(currentPage != lastPageNum){ %>
    <a href="">後ろのページ</a>
<%} %>
</div>
</section>
</div>
  <!--投稿画像をクリックするとポップアップウインドウが表示-->
  <!--図鑑を見るをクリックするとMyaniBookServletにとぶ
<p><a href="/coffee_Milk/MyAniBookServlet">図鑑を見る</a></p>-->
</body>
</html>