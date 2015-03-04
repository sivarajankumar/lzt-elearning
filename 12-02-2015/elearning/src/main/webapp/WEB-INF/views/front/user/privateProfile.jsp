<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="wrap">
	<div class="cover">
		<img alt="Avarta"
			src="/elearning/resources/images/front/${user.getPhoto()}">
		<div class="suggest-fb">
		<div>
			<h1>${user.getFirstName().toUpperCase()} ${user.getLastName().toUpperCase() }</h1>
			Để kết nối với  ${user.getFirstName().toUpperCase()} đăng ký ngay hôm nay.
		</div>
		<button class="register-fb" type="button"
			data-id="${user.getIdUser() }">
			Đăng Kí
		</button>	
		
		<button class="login-fb" type="button"
			data-id="${user.getIdUser() }">
			Đăng Nhập
		</button>
		</div>
	</div>
</div>