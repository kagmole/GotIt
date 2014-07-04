package ch.hearc.gotit.daos;

import java.util.List;

import ch.hearc.gotit.entities.ModuleEntity;

public interface ModuleDao extends BasicDao<ModuleEntity, Integer> {
	
	public List<ModuleEntity> findRangeWithSchool(Integer schoolPk, int offset, int limit);
}
