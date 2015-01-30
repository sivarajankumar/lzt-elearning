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
	$(".item-user").click(function(){
		var id = $(this).data("id");
		$("[name='toUser']").val(id);
		dialog = $( "#dialog" ).dialog({
			appendTo: "#dialogPlace",
			close: function( event, ui ) {
				$(this).dialog('destroy');
			},
			autoOpen  : false,
		}).dialog('open');
	});
	
	$("#message").submit(function( event ) {
		 event.preventDefault();
		 if($("[name='message']").val()!=null && $("[name='message']").val()!=''){
			 $(".display-message").append("<li>me:"+ $("[name='message']").val() +"</li>");
		 }
		
		  $.ajax({
		      type: "POST",
		      contentType : 'application/json',
		      dataType : 'json',
		      url: "/elearning/sendMessage",
		      processData: false,
		      data: JSON.stringify($("#message").serializeObject()),
		     // data: JSON.stringify({toUser:"1",message:"chanvai"}), // Note it is important
		      success :function(result) {
		       // do what ever you want with data
		      }
		  });
	});

});