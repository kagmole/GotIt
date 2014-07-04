package ch.hearc.gotit.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.hearc.gotit.daos.BasicDao;
import ch.hearc.gotit.daos.EventDao;
import ch.hearc.gotit.entities.EventEntity;
import ch.hearc.gotit.services.EventService;

@Service("eventService")
public class EventServiceImpl extends BasicServiceImpl<EventEntity, Integer> implements EventService {
	
	@Autowired
	private EventDao eventDao;

	@Override
	protected BasicDao<EventEntity, Integer> getDao() {
		return eventDao;
	}

	@Override
	@Transactional(readOnly = true)
	public List<EventEntity> findRangeWithSchool(Integer schoolPk, int offset, int limit) {
		return eventDao.findRangeWithSchool(schoolPk, offset, limit);
	}

	@Override
	@Transactional(readOnly = true)
	public List<EventEntity> findRangeWithTraining(Integer trainingPk, int offset, int limit) {
		return eventDao.findRangeWithTraining(trainingPk, offset, limit);
	}

	@Override
	@Transactional(readOnly = true)
	public List<EventEntity> findRangeWithCourse(Integer coursePk, int offset, int limit) {
		return eventDao.findRangeWithCourse(coursePk, offset, limit);
	}
}
