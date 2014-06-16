package ch.hearc.gotit.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.hearc.gotit.daos.BasicDao;
import ch.hearc.gotit.daos.CourseDao;
import ch.hearc.gotit.entities.ClassEntity;
import ch.hearc.gotit.entities.CourseEntity;
import ch.hearc.gotit.services.CourseService;

@Service("courseService")
public class CourseServiceImpl extends BasicServiceImpl<CourseEntity, Integer> implements CourseService {

	@Autowired
	private CourseDao courseDao;
	
	@Override
	protected BasicDao<CourseEntity, Integer> getDao() {
		return courseDao;
	}
	
	@Override
	public void addClass(CourseEntity courseEntity, ClassEntity classEntity) {
		courseEntity.getClassesList().add(classEntity);
		
		courseDao.update(courseEntity);
	}
}
