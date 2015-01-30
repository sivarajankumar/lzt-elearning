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
$( document ).ready(function() {
	$(".item-user").click(function(){
		var id = $(this).data("id");
		$("[name='toUser']").val(id);
		var dialog = $( "#dialog" ).dialog();
		$("#message").submit(function( event ) {
			 event.preventDefault();
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
	})

});