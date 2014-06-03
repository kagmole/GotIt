package ch.hearc.gotit.services;

import ch.hearc.gotit.daos.CourseDao;
import ch.hearc.gotit.entities.ClassEntity;
import ch.hearc.gotit.entities.CourseEntity;

public interface CourseService extends BasicService<CourseEntity, Integer>, CourseDao {

	public void addClass(CourseEntity courseEntity, ClassEntity classEntity);
}
