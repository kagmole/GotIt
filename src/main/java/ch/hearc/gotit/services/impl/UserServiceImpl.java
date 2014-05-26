package ch.hearc.gotit.services.impl;

import ch.hearc.gotit.daos.BasicDao;
import ch.hearc.gotit.daos.UserDao;
import ch.hearc.gotit.entities.UserEntity;
import ch.hearc.gotit.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl extends BasicServiceImpl<UserEntity, Integer> implements UserService {

	@Autowired
	private UserDao dao;
	
	@Override
	protected BasicDao<UserEntity, Integer> getDao() {
		return dao;
	}
}