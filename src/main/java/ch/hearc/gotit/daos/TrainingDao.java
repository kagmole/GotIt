package ch.hearc.gotit.daos;

import java.util.List;

import ch.hearc.gotit.entities.TrainingEntity;

public interface TrainingDao extends BasicDao<TrainingEntity, Integer> {
	
	public List<TrainingEntity> findRangeWithSchool(Integer schoolPk, int offset, int limit);
}
