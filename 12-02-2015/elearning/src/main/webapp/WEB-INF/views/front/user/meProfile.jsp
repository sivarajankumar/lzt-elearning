<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="wrap">
	<div class="cover">
		<img alt="Avarta"
			src="/elearning/resources/images/front/${user.getPhoto()}">
		<div class="tooltip_fb">
			<button class="fb_btn_add_friend" type="button"
				data-id="${user.getIdUser() }">Cập nhật thông tin</button>
		</div>
	</div>
</div>