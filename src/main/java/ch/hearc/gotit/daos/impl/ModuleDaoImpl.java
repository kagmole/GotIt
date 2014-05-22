package ch.hearc.gotit.daos.impl;

import ch.hearc.gotit.daos.ModuleDao;
import ch.hearc.gotit.entities.ModuleEntity;

import org.springframework.stereotype.Repository;

@Repository("moduleDao")
public class ModuleDaoImpl extends BasicDaoImpl<ModuleEntity, Integer> implements ModuleDao {

	public ModuleDaoImpl() {
		super(ModuleEntity.class);
	}
}
