/**
 *
 */
 'use strict';
/*いいねボタンを押したときの処理*/
let button = document.getElementById("heart");
function changeColor(button)
{
//白ハートのクラスを取得
  var whiteHeart = button.querySelector(".white-heart");
  var redHeart = button.querySelector(".red-heart");
  whiteHeart.classList.toggle("hidden");
  redHeart.classList.toggle("hidden");
}