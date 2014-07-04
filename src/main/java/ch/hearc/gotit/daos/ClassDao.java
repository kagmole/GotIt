package ch.hearc.gotit.daos;

import java.util.List;

import ch.hearc.gotit.entities.ClassEntity;

public interface ClassDao extends BasicDao<ClassEntity, Integer> {
	
	public List<ClassEntity> findRangeWithCourse(Integer coursePk, int offset, int limit);
}
