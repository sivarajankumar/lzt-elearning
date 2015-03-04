package org.lztvn.elearning.service;

import java.util.List;
import java.util.Map;

import org.lztvn.elearning.dao.IFriendDAO;
import org.lztvn.elearning.entities.Friend;
import org.lztvn.elearning.entities.User;
import org.lztvn.elearning.unityclass.Notify;

public class FriendServiceImpl implements IFriendService{
	IFriendDAO dao;
	@Override
	public Long addFriend(Friend friend) {
		// TODO Auto-generated method stub
		return dao.addFriend(friend);
	}

	public void setDao(IFriendDAO dao) {
		this.dao = dao;
	}

	@Override
	public Map<String, List<Notify>> getAllRequestFriend(User user) {
		// TODO Auto-generated method stub
		return dao.getAllRequestFriend(user);
	}

}
