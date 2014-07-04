package ch.hearc.gotit.daos;

import java.util.List;

import ch.hearc.gotit.entities.EmployeeEntity;

public interface EmployeeDao extends BasicDao<EmployeeEntity, Integer> {
	
	public List<EmployeeEntity> findRangeWithSchool(Integer schoolPk, int offset, int limit);
}
