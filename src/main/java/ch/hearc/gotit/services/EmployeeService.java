package ch.hearc.gotit.services;

import ch.hearc.gotit.daos.EmployeeDao;
import ch.hearc.gotit.entities.EmployeeEntity;

public interface EmployeeService extends BasicService<EmployeeEntity, Integer>, EmployeeDao {
}
