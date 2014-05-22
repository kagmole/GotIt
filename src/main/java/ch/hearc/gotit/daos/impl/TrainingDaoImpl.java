package ch.hearc.gotit.daos.impl;

import ch.hearc.gotit.daos.TrainingDao;
import ch.hearc.gotit.entities.TrainingEntity;

import org.springframework.stereotype.Repository;

@Repository("trainingDao")
public class TrainingDaoImpl extends BasicDaoImpl<TrainingEntity, Integer> implements TrainingDao {

	public TrainingDaoImpl() {
		super(TrainingEntity.class);
	}
}
