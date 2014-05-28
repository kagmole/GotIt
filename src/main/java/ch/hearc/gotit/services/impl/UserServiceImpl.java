package ch.hearc.gotit.services.impl;

import ch.hearc.gotit.daos.BasicDao;
import ch.hearc.gotit.daos.UserDao;
import ch.hearc.gotit.entities.UserEntity;
import ch.hearc.gotit.services.AuthorityService;
import ch.hearc.gotit.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl extends BasicServiceImpl<UserEntity, Integer> implements UserService {

	@Autowired
	private AuthorityService authorityService;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	protected BasicDao<UserEntity, Integer> getDao() {
		return userDao;
	}
	
	@Override
	@Transactional(readOnly = false)
	public void create(UserEntity userEntity) {
		userEntity.setEnabled(true);
		userEntity.setAuthority(authorityService.findByRole("user"));
		
		userDao.create(userEntity);
	}
}
