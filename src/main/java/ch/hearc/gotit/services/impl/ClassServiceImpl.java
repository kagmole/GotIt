package ch.hearc.gotit.services.impl;

import java.util.List;

import ch.hearc.gotit.daos.BasicDao;
import ch.hearc.gotit.daos.ClassDao;
import ch.hearc.gotit.entities.ClassEntity;
import ch.hearc.gotit.entities.SlideEntity;
import ch.hearc.gotit.services.ClassService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("classService")
public class ClassServiceImpl extends BasicServiceImpl<ClassEntity, Integer> implements ClassService {

	@Autowired
	private ClassDao classDao;
	
	@Override
	protected BasicDao<ClassEntity, Integer> getDao() {
		return classDao;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ClassEntity> findRangeWithCourse(Integer coursePk, int offset, int limit) {
		return classDao.findRangeWithCourse(coursePk, offset, limit);
	}
	
	@Override
	public void addSlide(ClassEntity classEntity, SlideEntity slideEntity) {
		classEntity.getSlidesList().add(slideEntity);
		
		classDao.update(classEntity);
	}
}
