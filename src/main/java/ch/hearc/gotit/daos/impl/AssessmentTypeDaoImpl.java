package ch.hearc.gotit.daos.impl;

import ch.hearc.gotit.daos.AssessmentTypeDao;
import ch.hearc.gotit.entities.AssessmentTypeEntity;

import org.springframework.stereotype.Repository;

@Repository("assessmentTypeDao")
public class AssessmentTypeDaoImpl extends BasicDaoImpl<AssessmentTypeEntity, Integer> implements AssessmentTypeDao {

	public AssessmentTypeDaoImpl() {
		super(AssessmentTypeEntity.class);
	}
}
