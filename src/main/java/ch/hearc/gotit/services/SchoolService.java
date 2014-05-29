package ch.hearc.gotit.services;

import ch.hearc.gotit.daos.SchoolDao;
import ch.hearc.gotit.entities.SchoolEntity;

public interface SchoolService extends BasicService<SchoolEntity, Integer>, SchoolDao {
}
