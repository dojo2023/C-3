<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Myペット図鑑</title>
		<link rel="stylesheet" href="css/myanibook.css">
		<script src="js/myanibook.js"></script>
		</head>
<body>
	<p>所有者、閲覧者、メインからMyペット図鑑をクリックした人によって見え方が変わるページ。</p>
	<!-- とりあえず投稿者のページを作成してみる。閲覧者と非ログイン者は投稿者のページの縮小版だから -->
	<div>
  		<h2><a href="/coffee_Milk/MyAniAddServlet"><img src="img/ペット追加ボタン.png" alt="ペット追加"></a></h2>
    	<!-- このボタンは5匹ペットが登録されていた場合javascriptで阻止される。下にエラーメッセージ表示用のspanタグを作成 -->
    	<span id="error_message"></span>
    </div>
	<div class="tab-panel">
 	 	<!--タブ-->
 		<ul class="tab-group">
    		<li class="tab tab-A is-active">1</li>
    		<li class="tab tab-B">2</li>
    		<li class="tab tab-C">3</li>
    		<li class="tab tab-D">4</li>
    		<li class="tab tab-E">5</li>
 		</ul>

  		<!--タブを切り替えて表示するコンテンツ-->
 	 	<div class="panel-group">
 	 		<div class="panel tab-A is-show">
 	 			<h1>Myペットプロフィール</h1><br>
				<p>データベースから画像を何とか表示する</p>
				ペットの名前<br>
				<p>うみちゃん</p>
				性別<br>
				<p>メス</p>
				誕生日<br>
				<p>3月3日</p>
				鳴き声<br>
				<p>鳴き声をどうやって出力するのかわからんけど出力</p>
				アピールポイント<br>
				<p>食べることが大好きで、ぴょんぴょんジャンプします。知らない人には警戒心が強いですが、一度懐いたら忠誠心が強い子です♪</p></div>
			<div class="panel tab-B">
				<h1>Myペットプロフィール</h1><br>
				<p>データベースから画像を何とか表示する</p>
				ペットの名前<br>
				<p>c:outにvalue属性を付けてペットの名前を出力</p>
				性別<br>
				<p>c:outにvalue属性を付けて性別を出力</p>
				誕生日<br>
				<p>c:outにvalue属性を付けて誕生日を出力</p>
				鳴き声<br>
				<p>鳴き声をどうやって出力するのかわからんけど出力</p>
				アピールポイント<br>
				<p>c:outにvalue属性を付けてアピールポイントを出力</p>
			</div>
			<div class="panel tab-C">
				<h1>Myペットプロフィール</h1><br>
				<p>データベースから画像を何とか表示する</p>
				ペットの名前<br>
				<p>c:outにvalue属性を付けてペットの名前を出力</p>
				性別<br>
				<p>c:outにvalue属性を付けて性別を出力</p>
				誕生日<br>
				<p>c:outにvalue属性を付けて誕生日を出力</p>
				鳴き声<br>
				<p>鳴き声をどうやって出力するのかわからんけど出力</p>
				アピールポイント<br>
				<p>c:outにvalue属性を付けてアピールポイントを出力</p>
			</div>
			<div class="panel tab-D">
				<h1>Myペットプロフィール</h1><br>
				<p>データベースから画像を何とか表示する</p>
				ペットの名前<br>
				<p>c:outにvalue属性を付けてペットの名前を出力</p>
				性別<br>
				<p>c:outにvalue属性を付けて性別を出力</p>
				誕生日<br>
				<p>c:outにvalue属性を付けて誕生日を出力</p>
				鳴き声<br>
				<p>鳴き声をどうやって出力するのかわからんけど出力</p>
				アピールポイント<br>
				<p>c:outにvalue属性を付けてアピールポイントを出力</p>
			</div>
			<div class="panel tab-E">
				<h1>Myペットプロフィール</h1><br>
				<p>データベースから画像を何とか表示する</p>
				ペットの名前<br>
				<p>c:outにvalue属性を付けてペットの名前を出力</p>
				性別<br>
				<p>c:outにvalue属性を付けて性別を出力</p>
				誕生日<br>
				<p>c:outにvalue属性を付けて誕生日を出力</p>
				鳴き声<br>
				<p>鳴き声をどうやって出力するのかわからんけど出力</p>
				アピールポイント<br>
				<p>c:outにvalue属性を付けてアピールポイントを出力</p>
			</div>
		</div>
	</div>
	<h2><a href="/coffee_Milk/MyAniAddServlet"><img src="img/ペット編集ボタン.png" alt="編集"></a></h2>
	<h2><a href="/coffee_Milk/UpdateDeleteServlet"><img src="img/ペット削除ボタン.png" alt="削除"></a></h2>
	<h2><a href="/coffee_Milk/AniPostServlet"><img src="img/ペット投稿ボタン.png" alt="投稿"></a></h2>
</body>
</html>