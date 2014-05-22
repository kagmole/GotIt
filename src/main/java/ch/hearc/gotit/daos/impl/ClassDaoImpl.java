package ch.hearc.gotit.daos.impl;

import ch.hearc.gotit.daos.ClassDao;
import ch.hearc.gotit.entities.ClassEntity;

import org.springframework.stereotype.Repository;

@Repository("classDao")
public class ClassDaoImpl extends BasicDaoImpl<ClassEntity, Integer> implements ClassDao {

	public ClassDaoImpl() {
		super(ClassEntity.class);
	}
}
