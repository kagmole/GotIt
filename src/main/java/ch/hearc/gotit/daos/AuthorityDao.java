package ch.hearc.gotit.daos;

import ch.hearc.gotit.entities.AuthorityEntity;

public interface AuthorityDao extends BasicDao<AuthorityEntity, Integer> {
	
	public AuthorityEntity findByRole(String role);
}
