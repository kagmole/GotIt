package ch.hearc.gotit.daos.impl;

import ch.hearc.gotit.daos.StudentTrainingDao;
import ch.hearc.gotit.entities.StudentTrainingEntity;
import ch.hearc.gotit.entities.pks.StudentTrainingPk;

import org.springframework.stereotype.Repository;

@Repository("studentTrainingDao")
public class StudentTrainingDaoImpl extends BasicDaoImpl<StudentTrainingEntity, StudentTrainingPk> implements StudentTrainingDao {

	public StudentTrainingDaoImpl() {
		super(StudentTrainingEntity.class);
	}
}
