package ch.hearc.gotit.daos.impl;

import ch.hearc.gotit.daos.AssessmentDao;
import ch.hearc.gotit.entities.AssessmentEntity;

import org.springframework.stereotype.Repository;

@Repository("assessmentDao")
public class AssessmentDaoImpl extends BasicDaoImpl<AssessmentEntity, Integer> implements AssessmentDao {

	public AssessmentDaoImpl() {
		super(AssessmentEntity.class);
	}
}