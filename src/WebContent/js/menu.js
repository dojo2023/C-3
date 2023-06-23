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
	// /coffee_Milk/FavoriteServlet?posts_id=1&on=true

	//idごとにいいねをカウントする処理
	let post_id =button.firstElementChild.value;
    //var post_id = button.querySelector(".fav_post");//favoriteServletの例外
	//let post_id =document.getElementById(post_id).value;   //初期化のエラー
	//let post_id = document.getAttributeById(post_id).value;
	//let post_id =document.getElementsByName("posts_id");


	xhr.send( 'posts_id='+post_id+'&on=true' );	//いいねがついたとき

	//xhr.send( 'posts_id=1&on=false' );  //いいねをはずしたとき
}



