/**
 * 
 */
$( document ).ready(function() {
	$(document).on('click', '.login-fb' ,function() {
		 window.location.href = "/elearning/lstcourses/login?next="+encodeURIComponent(window.location.href);
	});
	$(document).on('click', '.register-fb' ,function() {
		 window.location.href = "/elearning/lstcourses/register?next="+encodeURIComponent(window.location.href);
	});
})