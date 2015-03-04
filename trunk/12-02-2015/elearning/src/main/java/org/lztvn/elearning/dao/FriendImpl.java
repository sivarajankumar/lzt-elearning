package org.lztvn.elearning.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.dialect.FirebirdDialect;
import org.lztvn.elearning.entities.Friend;
import org.lztvn.elearning.entities.Message;
import org.lztvn.elearning.entities.User;
import org.lztvn.elearning.unityclass.Notify;
import org.springframework.transaction.annotation.Transactional;

public class FriendImpl implements IFriendDAO{
	@PersistenceContext
	EntityManager em;
	@Override
	@Transactional
	public Long addFriend(Friend friend) {
		em.persist(friend);
		em.flush();
		return friend.getId();
	}
	@Override
	public Map<String, List<Notify>> getAllRequestFriend(User user) {
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
			nf.fromName = friend.getUserA().getFirstName();
			nf.fromPic = friend.getUserA().getPhoto();
			nf.toUser = user.getIdUser();
			nf.toName = user.getFirstName();
			nf.toPic = user.getPhoto();
			lstNotify.add(nf);
		}
		if(lstNotify.size()>0){
		map.put("friend", lstNotify);
		}
		return map;
	}
}
