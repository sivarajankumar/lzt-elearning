package org.lztvn.elearning.dao;

import java.util.List;
import java.util.Map;

import org.lztvn.elearning.entities.Message;
import org.lztvn.elearning.entities.User;
import org.lztvn.elearning.unityclass.FriendStatus;
import org.lztvn.elearning.unityclass.Notify;

public interface IUserDao {
	public Long addUser(User u);
	public void deleteUser(Long idUser);
	public void modifierUser(User u);
	public List<User> login(String username,String password);
	public List<User> listUser();
	public List<User> listTeacher();
	public User getUser(Long idUser);
	public User getUserByUsername(String userName);
	public List<User> getAllUserExceptMe(User user);
	public List<Message> getMessageNotifyToMe(User user);
	public FriendStatus relation(User userA, User userB);
	public Map<String,List<Notify>> getAllNotify(User user);
}
