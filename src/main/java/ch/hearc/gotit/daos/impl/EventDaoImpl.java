package ch.hearc.gotit.daos.impl;

import ch.hearc.gotit.daos.EventDao;
import ch.hearc.gotit.entities.EventEntity;

import org.springframework.stereotype.Repository;

@Repository("eventDao")
public class EventDaoImpl extends BasicDaoImpl<EventEntity, Integer> implements EventDao {

	public EventDaoImpl() {
		super(EventEntity.class);
	}
}
