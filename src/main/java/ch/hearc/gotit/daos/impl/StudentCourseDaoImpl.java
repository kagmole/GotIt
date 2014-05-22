package ch.hearc.gotit.daos.impl;

import ch.hearc.gotit.daos.StudentCourseDao;
import ch.hearc.gotit.entities.StudentCourseEntity;
import ch.hearc.gotit.entities.pks.StudentCoursePK;

import org.springframework.stereotype.Repository;

@Repository("studentCourseDao")
public class StudentCourseDaoImpl extends BasicDaoImpl<StudentCourseEntity, StudentCoursePK> implements StudentCourseDao {

	public StudentCourseDaoImpl() {
		super(StudentCourseEntity.class);
	}
}
