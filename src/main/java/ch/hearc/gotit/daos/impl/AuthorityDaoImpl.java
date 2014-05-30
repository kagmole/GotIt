package ch.hearc.gotit.daos.impl;

import ch.hearc.gotit.daos.AuthorityDao;
import ch.hearc.gotit.entities.AuthorityEntity;

import org.springframework.stereotype.Repository;

@Repository("authorityDao")
public class AuthorityDaoImpl extends BasicDaoImpl<AuthorityEntity, Integer> implements AuthorityDao {

	public AuthorityDaoImpl() {
		super(AuthorityEntity.class);
	}

	@Override
	public AuthorityEntity findByRole(String role) {
		return (AuthorityEntity) getCurrentSession()
				.getNamedQuery("AuthorityQuery.findByRole")
				.setString("role", role)
				.uniqueResult();
	}
}
