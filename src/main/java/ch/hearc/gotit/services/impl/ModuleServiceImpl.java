package ch.hearc.gotit.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.hearc.gotit.daos.BasicDao;
import ch.hearc.gotit.daos.ModuleDao;
import ch.hearc.gotit.entities.CourseEntity;
import ch.hearc.gotit.entities.ModuleEntity;
import ch.hearc.gotit.services.ModuleService;

@Service("moduleService")
public class ModuleServiceImpl extends BasicServiceImpl<ModuleEntity, Integer> implements ModuleService {

	@Autowired
	private ModuleDao moduleDao;
	
	@Override
	protected BasicDao<ModuleEntity, Integer> getDao() {
		return moduleDao;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ModuleEntity> findRangeWithSchool(Integer schoolPk, int offset, int limit) {
		return moduleDao.findRangeWithSchool(schoolPk, offset, limit);
	}
	
	@Override
	public void addCourse(ModuleEntity moduleEntity, CourseEntity courseEntity) {
		moduleEntity.getCoursesList().add(courseEntity);
		
		moduleDao.update(moduleEntity);
	}
}
