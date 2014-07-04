package ch.hearc.gotit.daos.impl;

import java.util.List;

import ch.hearc.gotit.daos.EventDao;
import ch.hearc.gotit.entities.EventEntity;

import org.springframework.stereotype.Repository;

@Repository("eventDao")
public class EventDaoImpl extends BasicDaoImpl<EventEntity, Integer> implements EventDao {

	public EventDaoImpl() {
		super(EventEntity.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EventEntity> findRangeWithSchool(Integer schoolPk, int offset, int limit) {
		return getCurrentSession()
				.getNamedQuery("EventQuery.findRangeWithSchool")
				.setInteger("schoolPk", schoolPk)
				.setFirstResult(offset)
				.setMaxResults(limit)
				.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EventEntity> findRangeWithTraining(Integer trainingPk, int offset, int limit) {
		return getCurrentSession()
				.getNamedQuery("EventQuery.findRangeWithTraining")
				.setInteger("trainingPk", trainingPk)
				.setFirstResult(offset)
				.setMaxResults(limit)
				.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EventEntity> findRangeWithCourse(Integer coursePk, int offset, int limit) {
		return getCurrentSession()
				.getNamedQuery("EventQuery.findRangeWithCourse")
				.setInteger("coursePk", coursePk)
				.setFirstResult(offset)
				.setMaxResults(limit)
				.list();
	}
}
