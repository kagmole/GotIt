package ch.hearc.gotit.daos.impl;

import ch.hearc.gotit.daos.AssessmentStudentDao;
import ch.hearc.gotit.entities.AssessmentStudentEntity;
import ch.hearc.gotit.entities.pks.AssessmentStudentPk;

import org.springframework.stereotype.Repository;

@Repository("assessmentStudentDao")
public class AssessmentStudentDaoImpl extends BasicDaoImpl<AssessmentStudentEntity, AssessmentStudentPk> implements AssessmentStudentDao {

	public AssessmentStudentDaoImpl() {
		super(AssessmentStudentEntity.class);
	}
}
