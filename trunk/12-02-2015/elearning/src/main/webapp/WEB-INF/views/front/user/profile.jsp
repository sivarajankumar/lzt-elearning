<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="wrap">
	<div class="cover">
		<img alt="Avarta"
			src="/elearning/resources/images/front/${user.getPhoto()}">
		<div class="tooltip_fb">
			<button class="fb_btn_add_friend" type="button"
				data-id="${user.getIdUser() }">Tin nhắn</button>
			<c:if test="${relation eq 'NOT_ADD'}">
				<button class="fb_btn_add_friend addFriend" type="button"
					data-id="${user.getIdUser() }">
					<i class="icon-add-friend"></i> Kết bạn
				</button>
			</c:if>
			<c:if test="${relation eq 'P_ADD'}">
				<button class="fb_btn_add_friend confirm-friend" type="button"
					data-id="${user.getIdUser() }">
					<i class="icon-add-friend"></i> Chấp Nhận
				</button>
			</c:if>
			<c:if test="${relation eq 'ADD_NOT_CHECK'|| relation eq 'ADD_CHECK'}">
				<button class="fb_btn_add_friend" type="button"
					data-id="${user.getIdUser() }">
					<i class="icon-add-friend"></i> Đã gửi lời mời kết bạn

				</button>
			</c:if>
			<c:if test="${relation eq 'FRIEND'}">
				<button class="fb_btn_add_friend" type="button"
					data-id="${user.getIdUser() }">
					<i class="icon-add-friend"></i> Bạn bè
				</button>
			</c:if>
		</div>
	</div>
	<c:if test="${relation eq 'NOT_ADD'}">
		<div class="invite-friend">
			<h3>BẠN CÓ BIẾT ${user.getFirstName().toUpperCase()} KHÔNG?</h3>
			<div class="addFriend">
				<div class="col-lg-7 col-sm-7">
					<span>Để xem những điều bạn ấy chia sẻ với bạn bè, hãy gửi
						lời mời kết bạn cho bạn ấy.</span>
				</div>
				<div class="col-lg-5 col-sm-5">
					<div class="friend">
						<button class="fb_btn_add_friend" type="button"
							data-id="${user.getIdUser() }">
							<i class="icon-add-friend"></i>Kết bạn
						</button>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</c:if>
</div>