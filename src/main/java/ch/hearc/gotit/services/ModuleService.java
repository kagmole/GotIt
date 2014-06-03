package ch.hearc.gotit.services;

import ch.hearc.gotit.daos.ModuleDao;
import ch.hearc.gotit.entities.CourseEntity;
import ch.hearc.gotit.entities.ModuleEntity;

public interface ModuleService extends BasicService<ModuleEntity, Integer>, ModuleDao {
	
	public void addCourse(ModuleEntity moduleEntity, CourseEntity courseEntity);
}
