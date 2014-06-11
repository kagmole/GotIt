package ch.hearc.gotit.services.impl;

import ch.hearc.gotit.daos.BasicDao;
import ch.hearc.gotit.daos.ClassDao;
import ch.hearc.gotit.entities.ClassEntity;
import ch.hearc.gotit.entities.SlideEntity;
import ch.hearc.gotit.services.ClassService;

import org.springframework.beans.factory.annotation.Autowired;

public class ClassServiceImpl extends BasicServiceImpl<ClassEntity, Integer> implements ClassService {

	@Autowired
	private ClassDao classDao;
	
	@Override
	protected BasicDao<ClassEntity, Integer> getDao() {
		return classDao;
	}
	
	@Override
	public void addSlide(ClassEntity classEntity, SlideEntity slideEntity) {
		classEntity.getSlidesList().add(slideEntity);
		
		classDao.update(classEntity);
	}
}
