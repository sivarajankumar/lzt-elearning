package org.lztvn.elearning.dao;

import java.util.List;
import java.util.Map;

import org.lztvn.elearning.entities.Friend;
import org.lztvn.elearning.entities.User;
import org.lztvn.elearning.unityclass.Notify;



public interface IFriendDAO {
	public Long addFriend(Friend friend);
	public Map<String,List<Notify>> getAllRequestFriend(User user);
}
