package ch.hearc.gotit.services;

import ch.hearc.gotit.daos.EventDao;
import ch.hearc.gotit.entities.EventEntity;

public interface EventService extends BasicService<EventEntity, Integer>, EventDao {
}
