package org.lztvn.elearning.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.lztvn.elearning.entities.Friend;
import org.lztvn.elearning.entities.Message;
import org.lztvn.elearning.entities.User;
import org.lztvn.elearning.unityclass.FriendStatus;
import org.lztvn.elearning.unityclass.Notify;

public class UserDaoImpl implements IUserDao {
	@PersistenceContext
	private EntityManager em;
	@Override
	public Long addUser(User u) {
		em.persist(u);
		return u.getIdUser();
	}

	@Override
	public void deleteUser(Long idUser) {
		User u = em.find(User.class, idUser);
		em.remove(u);
	}

	@Override
	public void modifierUser(User u) {
	  em.merge(u);
	}

	@Override
	public List<User> login(String username,String password) {
		Query req = em
				.createQuery("select u from User u where u.username = :x and u.password = :y");
		req.setParameter("x",username);
		req.setParameter("y",password);
		return req.getResultList();
	}

	@Override
	public List<User> listUser() {
		Query req = em.createQuery("select u from User u");
		return req.getResultList();
	}
	@Override
	public User getUser(Long idUser) {
		User user = em.find(User.class, idUser);
		return user;
	}

	@Override
	public User getUserByUsername(String userName) {
		Query req = em
				.createQuery("select u from User u where u.username = :x");
		req.setParameter("x",userName);
		List result  = req.getResultList();
		if(result.size()>0){
			return (User)result.get(0);
		}
		return null;
	}

	@Override
	public List<User> listTeacher() {
		Query req = em.createQuery("select u from User u where u.typeUser ='teacher'");
		return req.getResultList();
	}
	
	@Override
	public List<User> getAllUserExceptMe(User me) {
		Query q = em.createQuery("SELECT u FROM User u WHERE u.idUser != :id");
		q.setParameter("id", me.getIdUser());
        try{ 
        @SuppressWarnings("unchecked")
		List<User> lstuser = (List<User>)q.getResultList();
        return lstuser;
        }catch(Exception e){ 	          
           return null; 
        } 
	}

	@Override
	public List<Message> getMessageNotifyToMe(User user) {
		user = (User)em.find(User.class, user.getIdUser());
		em.persist(user);
		List<Message> lstMessage = (List<Message>) user.getMessageToMe();
		List<Message> result = new ArrayList<Message>();
		for (Message message : lstMessage) {
			if(message.getStatus()==false){
				result.add(message);
			}
		}
		return result;
	}

	@Override
	public FriendStatus relation(User userA, User userB) {
		Query q = em.createQuery("SELECT u FROM Friend u WHERE u.fromUser = :fromA and u.toUser = :fromB");
		q.setParameter("fromA", userA.getIdUser());
		q.setParameter("fromB", userB.getIdUser());
        try{ 
        @SuppressWarnings("unchecked")
		List<Friend> lstuser = (List<Friend>)q.getResultList();
        if(lstuser!=null&&lstuser.size()>0){
        	Friend friend  = (Friend)lstuser.get(0);
        	if(friend.getStatus()){
        		return FriendStatus.FRIEND;
        	}else{
        		if(friend.getChecked()){
        			return FriendStatus.ADD_CHECK;
        		}else{
        			return FriendStatus.ADD_NOT_CHECK;
        		}
        	}
        }else{
        	q = em.createQuery("SELECT u FROM Friend u WHERE u.fromUser = :fromA and u.toUser = :fromB");
    		q.setParameter("fromA", userB.getIdUser());
    		q.setParameter("fromB", userA.getIdUser());
    		@SuppressWarnings("unchecked")
    		List<Friend> lst= (List<Friend>)q.getResultList();
    		 if(lst!=null&&lst.size()>0){
    	        	Friend friend  = (Friend)lst.get(0);
    	        	if(friend.getStatus()){
    	        		return FriendStatus.FRIEND;
    	        	}
    	        	return FriendStatus.P_ADD;
    	        	
    	        }
        }
        return FriendStatus.NOT_ADD;
        }catch(Exception e){ 	          
           return FriendStatus.NOT_ADD; 
        }
	}

	@Override
	public Map<String, List<Notify>> getAllNotify(User user) {
		Map<String, List<Notify>> map =   new HashMap<String, List<Notify>>();
		//frien request
		Query q = em.createQuery("SELECT u FROM Friend u WHERE u.toUser = :fromA and u.checked = false");
		q.setParameter("fromA", user.getIdUser());
		List<Notify> lstNotify = new ArrayList<Notify>();
		@SuppressWarnings("unchecked")
		List<Friend> lstFriend = (List<Friend>)q.getResultList();
		for (Friend friend : lstFriend) {
			Notify nf = new Notify();
			nf.fromUser = friend.getFromUser();
			nf.toUser = user.getIdUser();
			lstNotify.add(nf);
		}
		if(lstNotify.size()>0){
		map.put("friend", lstNotify);
		}
		//message request
		q = em.createQuery("SELECT u FROM Message u WHERE u.toUser = :fromA and u.status = false");
		q.setParameter("fromA", user.getIdUser());
		lstNotify = new ArrayList<Notify>();
		@SuppressWarnings("unchecked")
		List<Message> lstMessaage = (List<Message>)q.getResultList();
		for (Message message : lstMessaage) {
			Notify nf = new Notify();
			nf.fromUser = message.getFromUser();
			nf.toUser = user.getIdUser();
			lstNotify.add(nf);
		}
		if(lstNotify.size()>0){
		map.put("message", lstNotify);
		}
		return map;
	}
}
