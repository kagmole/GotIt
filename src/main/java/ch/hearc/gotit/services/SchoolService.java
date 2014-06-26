package ch.hearc.gotit.services;

import ch.hearc.gotit.daos.SchoolDao;
import ch.hearc.gotit.entities.EmployeeTypeEntity;
import ch.hearc.gotit.entities.SchoolEntity;
import ch.hearc.gotit.entities.TrainingEntity;
import ch.hearc.gotit.entities.UserEntity;

public interface SchoolService extends BasicService<SchoolEntity, Integer>, SchoolDao {
	
	public void createWithUser(SchoolEntity schoolEntity, UserEntity userEntity);
	
	public void addEmployeeWithType(SchoolEntity schoolEntity, UserEntity userEntity, EmployeeTypeEntity employeeTypeEntity);
	public void addStudent(SchoolEntity schoolEntity, UserEntity userEntity);
	public void addTraining(SchoolEntity schoolEntity, TrainingEntity trainingEntity);
}
