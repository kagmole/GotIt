package ch.hearc.gotit.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.hearc.gotit.daos.BasicDao;
import ch.hearc.gotit.daos.SchoolDao;
import ch.hearc.gotit.entities.SchoolEntity;
import ch.hearc.gotit.services.SchoolService;

@Service("schoolService")
public class SchoolServiceImpl extends BasicServiceImpl<SchoolEntity, Integer> implements SchoolService {

	@Autowired
	private SchoolDao schoolDao;
	
	@Override
	protected BasicDao<SchoolEntity, Integer> getDao() {
		return schoolDao;
	}
}
