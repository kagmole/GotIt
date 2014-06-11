package ch.hearc.gotit.services;

import ch.hearc.gotit.daos.ClassDao;
import ch.hearc.gotit.entities.ClassEntity;
import ch.hearc.gotit.entities.SlideEntity;

public interface ClassService extends BasicService<ClassEntity, Integer>, ClassDao {
	
	public void addSlide(ClassEntity classEntity, SlideEntity slideEntity);
}
