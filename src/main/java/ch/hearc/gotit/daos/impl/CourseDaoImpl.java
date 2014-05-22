package ch.hearc.gotit.daos.impl;

import ch.hearc.gotit.daos.CourseDao;
import ch.hearc.gotit.entities.CourseEntity;

import org.springframework.stereotype.Repository;

@Repository("courseDao")
public class CourseDaoImpl extends BasicDaoImpl<CourseEntity, Integer> implements CourseDao {

	public CourseDaoImpl() {
		super(CourseEntity.class);
	}
}
