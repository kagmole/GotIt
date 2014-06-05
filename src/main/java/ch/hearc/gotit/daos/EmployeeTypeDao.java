package ch.hearc.gotit.daos;

import ch.hearc.gotit.entities.EmployeeTypeEntity;

public interface EmployeeTypeDao extends BasicDao<EmployeeTypeEntity, Integer> {
	
	public EmployeeTypeEntity findOneWithName(String name);
}
