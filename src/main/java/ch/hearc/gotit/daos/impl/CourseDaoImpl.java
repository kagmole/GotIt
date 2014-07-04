package ch.hearc.gotit.daos.impl;

import java.util.List;

import ch.hearc.gotit.daos.CourseDao;
import ch.hearc.gotit.entities.CourseEntity;

import org.springframework.stereotype.Repository;

@Repository("courseDao")
public class CourseDaoImpl extends BasicDaoImpl<CourseEntity, Integer> implements CourseDao {

	public CourseDaoImpl() {
		super(CourseEntity.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CourseEntity> findRangeWithModule(Integer modulePk, int offset, int limit) {
		return getCurrentSession()
				.getNamedQuery("CourseQuery.findRangeWithModule")
				.setInteger("modulePk", modulePk)
				.setFirstResult(offset)
				.setMaxResults(limit)
				.list();
	}
}
