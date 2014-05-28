package ch.hearc.gotit.daos.impl;

import ch.hearc.gotit.daos.ModuleTrainingDao;
import ch.hearc.gotit.entities.ModuleTrainingEntity;
import ch.hearc.gotit.entities.pks.ModuleTrainingPk;

import org.springframework.stereotype.Repository;

@Repository("moduleTrainingDao")
public class ModuleTrainingDaoImpl extends BasicDaoImpl<ModuleTrainingEntity, ModuleTrainingPk> implements ModuleTrainingDao {

	public ModuleTrainingDaoImpl() {
		super(ModuleTrainingEntity.class);
	}
}
