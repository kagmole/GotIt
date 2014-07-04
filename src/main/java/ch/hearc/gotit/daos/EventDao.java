package ch.hearc.gotit.daos;

import java.util.List;

import ch.hearc.gotit.entities.EventEntity;

public interface EventDao extends BasicDao<EventEntity, Integer> {
	
	public List<EventEntity> findRangeWithSchool(Integer schoolPk, int offset, int limit);
	public List<EventEntity> findRangeWithTraining(Integer trainingPk, int offset, int limit);
	public List<EventEntity> findRangeWithCourse(Integer coursePk, int offset, int limit);
}
