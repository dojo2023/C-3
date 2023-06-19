/**
 *
 */
 'use strict';
/*いいねボタンを押したときの処理*/
let button = document.getElementById("heart");
function changeColor(button)
{
  var whiteHeart = button.querySelector(".white-heart");  //白ハートのクラスを取得
  var redHeart = button.querySelector(".red-heart");      //赤ハートのクラスを取得
  whiteHeart.classList.toggle("hidden");	//要素のクラスを切り替えるため
  redHeart.classList.toggle("hidden");		//要素のクラスを切り替えるためhiddenは非表示にするため
}
/*ポップアップウィンドウ*/
