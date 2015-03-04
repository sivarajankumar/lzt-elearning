package org.lztvn.elearning.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.lztvn.elearning.entities.Message;
import org.lztvn.elearning.entities.User;
import org.lztvn.elearning.unityclass.FriendStatus;
import org.lztvn.elearning.unityclass.Notify;

public interface IUserService {
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

	public FriendStatus relation(User me, User u);

	public Map<String,List<Notify>> getAllNotify(User user);
}
