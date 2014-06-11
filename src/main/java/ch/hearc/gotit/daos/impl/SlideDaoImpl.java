package ch.hearc.gotit.daos.impl;

import ch.hearc.gotit.daos.SlideDao;
import ch.hearc.gotit.entities.SlideEntity;

import org.springframework.stereotype.Repository;

@Repository("slideDao")
public class SlideDaoImpl extends BasicDaoImpl<SlideEntity, Integer> implements SlideDao {

	public SlideDaoImpl() {
		super(SlideEntity.class);
	}
}
