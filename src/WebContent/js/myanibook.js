'use strict';

// Webページの読み込みが完了した時に発動するイベント
document.addEventListener('DOMContentLoaded',
function(){
	// タブに対してクリックイベントを適用(クリックされたら何が起こるかは記述していない)
	const tabs = document.getElementsByClassName('tab');
	for(let i = 0; i < tabs.length; i++){
		tabs[i].addEventListener('click', tabSwitch, false);
	}
	// タブをクリックされたら実行される関数
	function tabSwitch(){

		// タブのclassの値を変更
		document.getElementsByClassName('is-active')[0].classList.remove('is-active');
		this.classList.add('is-active');

		// コンテンツのclassの値を変更
		document.getElementsByClassName('is-show')[0].classList.remove('is-show');
		const arrayTabs = Array.prototype.slice.call(tabs);
		const index = arrayTabs.indexOf(this);
		document.getElementsByClassName('panel')[index].classList.add('is-show');
	};
});