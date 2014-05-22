package ch.hearc.gotit.daos.impl;

import ch.hearc.gotit.daos.StudentDao;
import ch.hearc.gotit.entities.StudentEntity;

import org.springframework.stereotype.Repository;

@Repository("studentDao")
public class StudentDaoImpl extends BasicDaoImpl<StudentEntity, Integer> implements StudentDao {

	public StudentDaoImpl() {
		super(StudentEntity.class);
	}
}
