package ch.hearc.gotit.daos;

import ch.hearc.gotit.entities.SchoolEntity;
import ch.hearc.gotit.entities.UserEntity;

public interface SchoolDao extends BasicDao<SchoolEntity, Integer> {
	
	public UserEntity getFounderOf(SchoolEntity schoolEntity);
}
