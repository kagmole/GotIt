package ch.hearc.gotit.services;

import ch.hearc.gotit.daos.StudentDao;
import ch.hearc.gotit.entities.StudentEntity;

public interface StudentService extends BasicService<StudentEntity, Integer>, StudentDao {
}
