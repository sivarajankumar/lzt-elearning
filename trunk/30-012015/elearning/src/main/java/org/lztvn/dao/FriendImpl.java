package org.lztvn.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.lztvn.entity.Friend;
import org.springframework.transaction.annotation.Transactional;

public class FriendImpl implements IFriendDAO{
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public Friend addFriend(Friend friend) {
		em.persist(friend);
		em.flush();
		return friend;
	}
}
