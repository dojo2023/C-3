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

   //画像の大きさを固定
   //var canvas = document.getElementById("canvas");
   //var ctx = canvas.getContext("2d");

   //var img = new Image();
   //img.onload = function() {
  //var width = 200;
  //var height = 180;
  //canvas.width = width;
  //canvas.height = height;
  //ctx.drawImage(img,0,0,width,height);
  //}
  //img.src = "coffee_Milk/img/dog.jpeg"


