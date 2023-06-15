/*登録を押してIDかpasswordが空だった時のエラー文表示  */

'use strict';

document.getElementById('userregister_form').onsubmit = function() {

};

function checkUserregisterForm(){
	const id = document.getElementById('userregister_form').ID.value;
	const pw = document.getElementById('userregister_form').PW.value;
	if (id === "" || pw === "") {
    	document.getElementById('output').textContent = 'IDとPWを入力してください！';
		return false;
	}
}
