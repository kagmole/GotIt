package ch.hearc.gotit.services;

import ch.hearc.gotit.daos.SchoolDao;
import ch.hearc.gotit.entities.SchoolEntity;
import ch.hearc.gotit.entities.UserEntity;

public interface SchoolService extends BasicService<SchoolEntity, Integer>, SchoolDao {
	
	public void createByUser(SchoolEntity schoolEntity, UserEntity userEntity);
	
	public boolean isUpdateAuthorized(SchoolEntity schoolEntity, UserEntity userEntity);
	public boolean isDestroyAuthorized(SchoolEntity schoolEntity, UserEntity userEntity);
}
