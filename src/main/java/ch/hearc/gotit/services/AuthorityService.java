package ch.hearc.gotit.services;

import ch.hearc.gotit.daos.AuthorityDao;
import ch.hearc.gotit.entities.AuthorityEntity;

public interface AuthorityService extends BasicService<AuthorityEntity, Integer>, AuthorityDao {
}