package ch.hearc.gotit.services;

import ch.hearc.gotit.daos.EmployeeTypeDao;
import ch.hearc.gotit.entities.EmployeeTypeEntity;

public interface EmployeeTypeService extends BasicService<EmployeeTypeEntity, Integer>, EmployeeTypeDao {
}
