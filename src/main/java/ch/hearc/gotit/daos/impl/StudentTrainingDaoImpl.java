package ch.hearc.gotit.daos.impl;

import ch.hearc.gotit.daos.StudentTrainingDao;
import ch.hearc.gotit.entities.StudentTrainingEntity;
import ch.hearc.gotit.entities.pks.StudentTrainingPK;

import org.springframework.stereotype.Repository;

@Repository("studentTrainingDao")
public class StudentTrainingDaoImpl extends BasicDaoImpl<StudentTrainingEntity, StudentTrainingPK> implements StudentTrainingDao {

	public StudentTrainingDaoImpl() {
		super(StudentTrainingEntity.class);
	}
}
