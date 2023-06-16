'use strict';

window.addEventListener('DOMContentLoaded',function() {
    $('.header_link li').mouseover(function(e) {
        $('ul', this).stop().slideDown('fast');
    })
    .mouseout(function(e) {
        $('ul', this).stop().slideUp('fast');
    });
});