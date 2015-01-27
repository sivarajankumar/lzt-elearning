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
/*sample message*/
function addDevice(name, type, description) {
    var DeviceAction = {
        action: "add",
        name: name,
        type: type,
        description: description
    };
    socket.send(JSON.stringify(DeviceAction));
}
/**/
