package ch.hearc.gotit.daos.impl;

import ch.hearc.gotit.daos.AssessmentResultDao;
import ch.hearc.gotit.entities.AssessmentResultEntity;
import ch.hearc.gotit.entities.pks.AssessmentResultPK;

import org.springframework.stereotype.Repository;

@Repository("assessmentResultDao")
public class AssessmentResultDaoImpl extends BasicDaoImpl<AssessmentResultEntity, AssessmentResultPK> implements AssessmentResultDao {

	public AssessmentResultDaoImpl() {
		super(AssessmentResultEntity.class);
	}
}
