package ch.hearc.gotit.services.impl;

import java.util.List;

import ch.hearc.gotit.daos.BasicDao;
import ch.hearc.gotit.daos.SlideDao;
import ch.hearc.gotit.entities.SlideEntity;
import ch.hearc.gotit.services.SlideService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("slideService")
public class SlideServiceImpl extends BasicServiceImpl<SlideEntity, Integer> implements SlideService {
	
	@Autowired
	private SlideDao slideDao;
	
	@Override
	protected BasicDao<SlideEntity, Integer> getDao() {
		return slideDao;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SlideEntity> findRangeWithClass(Integer classPk, int offset, int limit) {
		return slideDao.findRangeWithClass(classPk, offset, limit);
	}
}
