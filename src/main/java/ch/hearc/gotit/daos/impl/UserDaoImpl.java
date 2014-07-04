package ch.hearc.gotit.daos.impl;

import ch.hearc.gotit.daos.UserDao;
import ch.hearc.gotit.entities.UserEntity;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends BasicDaoImpl<UserEntity, Integer> implements UserDao {

	public UserDaoImpl() {
		super(UserEntity.class);
	}

	@Override
	public UserEntity findOneWithUsername(String username) {
		return (UserEntity) getCurrentSession()
				.getNamedQuery("UserQuery.findOneWithUsername")
				.setString("username", username)
				.uniqueResult();
	}
}
