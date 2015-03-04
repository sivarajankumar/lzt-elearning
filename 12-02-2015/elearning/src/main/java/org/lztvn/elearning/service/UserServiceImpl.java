package org.lztvn.elearning.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.lztvn.elearning.dao.IUserDao;
import org.lztvn.elearning.entities.Message;
import org.lztvn.elearning.entities.User;
import org.lztvn.elearning.unityclass.FriendStatus;
import org.lztvn.elearning.unityclass.Notify;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class UserServiceImpl implements IUserService {
    private IUserDao dao;
	@Override
	public Long addUser(User u) {
		return dao.addUser(u);
	}

	@Override
	public void deleteUser(Long idUser) {
		dao.deleteUser(idUser);
		
	}

	@Override
	public void modifierUser(User u) {
		dao.modifierUser(u);
		
	}

	@Override
	public List<User> login(String username,String password) {
		return dao.login(username,password);
	}


	public void setDao(IUserDao dao) {
		this.dao = dao;
	}

	@Override
	public List<User> listUser() {
		// TODO Auto-generated method stub
		return dao.listUser();
	}

	@Override
	public User getUser(Long idUser) {
		return dao.getUser(idUser);
	}

	@Override
	public User getUserByUsername(String userName) {
		return dao.getUserByUsername(userName);
	}

	@Override
	public List<User> listTeacher() {
		return dao.listTeacher();
	}

	@Override
	public List<User> getAllUserExceptMe(User user) {
		// TODO Auto-generated method stub
		return dao.getAllUserExceptMe(user);
	}

	@Override
	public List<Message> getMessageNotifyToMe(User user) {
		// TODO Auto-generated method stub
		return dao.getMessageNotifyToMe(user);
	}

	@Override
	public FriendStatus relation(User userA, User userB) {
		// TODO Auto-generated method stub  
		return dao.relation(userA,userB);
	}

	@Override
	public Map<String, List<Notify>> getAllNotify(User user) {
		// TODO Auto-generated method stub
		return dao.getAllNotify(user);
	}
	

}
