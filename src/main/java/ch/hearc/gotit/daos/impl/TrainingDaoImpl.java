package ch.hearc.gotit.daos.impl;

import java.util.List;

import ch.hearc.gotit.daos.TrainingDao;
import ch.hearc.gotit.entities.TrainingEntity;

import org.springframework.stereotype.Repository;

@Repository("trainingDao")
public class TrainingDaoImpl extends BasicDaoImpl<TrainingEntity, Integer> implements TrainingDao {

	public TrainingDaoImpl() {
		super(TrainingEntity.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TrainingEntity> findRangeWithSchool(Integer schoolPk, int offset, int limit) {
		return getCurrentSession()
				.getNamedQuery("TrainingQuery.findRangeWithSchool")
				.setInteger("schoolPk", schoolPk)
				.setFirstResult(offset)
				.setMaxResults(limit)
				.list();
	}
}
