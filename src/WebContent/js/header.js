'use strict';

window.addEventListener('DOMContentLoaded',function() {
    $('.header_link li').mouseover(function(e) {
        $('ul', this).stop().slideDown('fast');
    })
    .mouseout(function(e) {
        $('ul', this).stop().slideUp('fast');
    });
});

    function kousin()
    {
    	const v = window.confirm("本当にログアウトしてよろしいですか？");
    	if(v == true)
    		{
    			return true;
    		}
    	else
    		{
    			return false;
    		}
    }
