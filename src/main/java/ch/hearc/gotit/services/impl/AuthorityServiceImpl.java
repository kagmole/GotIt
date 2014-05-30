package ch.hearc.gotit.services.impl;

import ch.hearc.gotit.daos.AuthorityDao;
import ch.hearc.gotit.daos.BasicDao;
import ch.hearc.gotit.entities.AuthorityEntity;
import ch.hearc.gotit.services.AuthorityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("authorityService")
public class AuthorityServiceImpl extends BasicServiceImpl<AuthorityEntity, Integer> implements AuthorityService {

	@Autowired
	private AuthorityDao authorityDao;
	
	@Override
	protected BasicDao<AuthorityEntity, Integer> getDao() {
		return authorityDao;
	}

	@Override
	@Transactional(readOnly = true)
	public AuthorityEntity findByRole(String role) {
		return authorityDao.findByRole(role);
	}
}
