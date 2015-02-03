package org.lztvn.service;

import org.lztvn.dao.IFriendDAO;
import org.lztvn.entity.Friend;
import org.springframework.transaction.annotation.Transactional;

public class FriendServiceImpl implements IFriendService{
	IFriendDAO dao;
	
	@Override
	@Transactional
	public Friend addFriend(Friend friend) {
		// TODO Auto-generated method stub
		return dao.addFriend(friend);
	}

	public void setDao(IFriendDAO dao) {
		this.dao = dao;
	}

}
