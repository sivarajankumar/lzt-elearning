/**
 * tcp client
 */
var socket = new WebSocket("ws://localhost:8080/elearning/actions");
socket.onmessage = onMessage;

function onMessage(event) {
    var data = JSON.parse(event.data);
    service(data);
}
function service(data){
	var fn = eval(data.method);
	fn(data.obj);
}
/*sample message, may be you not need to use*/
function addDevice(name, type, description) {
    var Device = {
        action: "add",
        name: name,
        type: type,
        description: description
    };
    var objectToSend = {
    		method:"test",
    		obj:Device,
    };
    socket.send(JSON.stringify(objectToSend));
}
/*From here you can custom for your application*/
function sendMessage (data){
	var idx = -1;
	$.each($(".message-button"), function( index, value ) {
		  if($($(".message-button")[index]).data("id") == data.fromUser){
			  idx = index;
			  return false;
		  }
		});
	if(idx!=-1){
		$($(".logchat")[idx]).append("<li>My friend:"+ data.message +"</li>");
	}else{
		var copy = $("#tab-friend").clone();
		$(".friendList-bot").append(copy);
		var lenght = $("#tab-friend .message-button").length;
		$($("#tab-friend .message-button")[lenght-2]).data("id",data.fromUser);
		$($(".logchat")[lenght-2]).append("<li>My friend:"+ data.message +"</li>");
	}
}
function notifyFriendRequest(data){
	alert("ok");
}