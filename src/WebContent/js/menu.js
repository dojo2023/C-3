/**
 *
 */
 /*いいねボタンを押したときの処理*/
let button = document.getElementById("heart");
function changeColor(button)
{
	var whiteHeart = button.querySelector(".white-heart");  //白ハートのクラスを取得
	var redHeart = button.querySelector(".red-heart");      //赤ハートのクラスを取得
	whiteHeart.classList.toggle("hidden");	//要素のクラスを切り替えるため
	redHeart.classList.toggle("hidden");		//要素のクラスを切り替えるためhiddenは非表示にするため

	var xhr = new XMLHttpRequest();
	xhr.open('POST', '/coffee_Milk/FavoriteServlet');
	xhr.setRequestHeader('content-type', 'application/x-www-form-urlencoded;charset=UTF-8');

	//posts_idを取得
	//いいねをつけたらtrue、外したらfalseをonに指定して送る
	xhr.send( 'posts_id=1&on=true' );	//いいねがついたとき

	//xhr.send( 'posts_id=1&on=false' );  //いいねをはずしたとき
}


/*ポップアップウィンドウ*/

