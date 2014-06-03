package ch.hearc.gotit.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import ch.hearc.gotit.daos.BasicDao;
import ch.hearc.gotit.daos.ModuleDao;
import ch.hearc.gotit.entities.CourseEntity;
import ch.hearc.gotit.entities.ModuleEntity;
import ch.hearc.gotit.services.ModuleService;

public class ModuleServiceImpl extends BasicServiceImpl<ModuleEntity, Integer> implements ModuleService {

	@Autowired
	private ModuleDao moduleDao;
	
	@Override
	protected BasicDao<ModuleEntity, Integer> getDao() {
		return moduleDao;
	}
	
	@Override
	public void addCourse(ModuleEntity moduleEntity, CourseEntity courseEntity) {
		moduleEntity.getCoursesList().add(courseEntity);
		
		moduleDao.update(moduleEntity);
	}
}
