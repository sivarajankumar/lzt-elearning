/**
 * 
 */
$.fn.serializeObject = function()
{
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name] !== undefined) {
			if (!o[this.name].push) {
				o[this.name] = [o[this.name]];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
};
var dialog;
$( document ).ready(function() {
	$(".show-friend").click(function(){
		var index = $('.show-friend').index(this);
		var me = $(this);
		$.ajax({
			type: "POST",
			contentType : 'application/json',
			dataType : 'json',
			url: "/elearning/getAllUser",
			processData: false,
			data: '',
			success :function(result) {
				me.toggle();
				var html = '';
				result.forEach(function(entry) {
					html +='<li data-id="'+entry.id+'">'+entry.name+'</li>';
				});
				$(".friends").append(html);
				$($(".hide-friend")[index]).toggle();
				$(".friends li").click(function(){
					var me = $(this);
					var idx = -1;
					$.each($(".message-button"), function( index, value ) {
						if($($(".message-button")[index]).data("id") == me.data("id")){
							idx = index;
							return false;
						}
					});
					if(idx == -1){
						var copy = $("#tab-friend").clone();
						$(".friendList-bot").append(copy);
						var lenght = $("#tab-friend .message-button").length;
						$($("#tab-friend .message-button")[lenght-2]).data("id",me.data("id"));
					}
				});
			}
		});
	});
	$(".hide-friend").click(function(){
		var index = $('.hide-friend').index(this);
		$(this).toggle();
		$($(".show-friend")[index]).toggle();
		$(".friends").empty();
	});
	$(document).on('click', '.message-button' ,function() {
		var toUser = $(this).data("id");
		var index = $(".message-button").index(this);
		if($($(".message-input")[index]).val()!=null && $($(".message-input")[index]).val().trim()!=''){
			$($(".logchat")[index]).append("<li>me:"+ $($(".message-input")[index]).val() +"</li>");
			$.ajax({
				type: "POST",
				contentType : 'application/json',
				dataType : 'json',
				url: "/elearning/sendMessage",
				processData: false,
				data: JSON.stringify({toUser:toUser,message:$($(".message-input")[index]).val()}),
				// data: JSON.stringify({toUser:"1",message:"chanvai"}), // Note it is important
				success :function(result) {
					// do what ever you want with data
				}
			});
		}
	});
	$(document).on('click', '.close' ,function() {
		var index = Math.floor($('.close').index(this)/2);
		$($(".wrap-content")[index]).remove();
	});
});