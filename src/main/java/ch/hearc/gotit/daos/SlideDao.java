package ch.hearc.gotit.daos;

import java.util.List;

import ch.hearc.gotit.entities.SlideEntity;

public interface SlideDao extends BasicDao<SlideEntity, Integer> {
	
	public List<SlideEntity> findRangeWithClass(Integer classPk, int offset, int limit);
}
