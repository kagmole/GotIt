package ch.hearc.gotit.daos;

import java.util.List;

import ch.hearc.gotit.entities.CourseEntity;

public interface CourseDao extends BasicDao<CourseEntity, Integer> {
	
	public List<CourseEntity> findRangeWithModule(Integer modulePk, int offset, int limit);
}
