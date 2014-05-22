package ch.hearc.gotit.daos.impl;

import ch.hearc.gotit.daos.SchoolDao;
import ch.hearc.gotit.entities.SchoolEntity;

import org.springframework.stereotype.Repository;

@Repository("schoolDao")
public class SchoolDaoImpl extends BasicDaoImpl<SchoolEntity, Integer> implements SchoolDao {

	public SchoolDaoImpl() {
		super(SchoolEntity.class);
	}
}
