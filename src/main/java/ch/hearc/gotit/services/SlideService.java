package ch.hearc.gotit.services;

import ch.hearc.gotit.daos.SlideDao;
import ch.hearc.gotit.entities.SlideEntity;

public interface SlideService extends BasicService<SlideEntity, Integer>, SlideDao {
}
