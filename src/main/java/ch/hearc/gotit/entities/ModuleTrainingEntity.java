package ch.hearc.gotit.entities;

import ch.hearc.gotit.entities.pks.ModuleTrainingPk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * TODO ENTITY JAVADOC
 * 
 * @author Dany Jupille
 */
@Entity
@Table(name = "modules_trainings")
public class ModuleTrainingEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected ModuleTrainingPk moduleTrainingPk;
    
    @Column(name = "weight")
    private Float weight;
    
    @MapsId("modulePk")
    @JoinColumn(name = "pk_module", referencedColumnName = "pk_module", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ModuleEntity module;
    
    @MapsId("trainingPk")
    @JoinColumn(name = "pk_training", referencedColumnName = "pk_training", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TrainingEntity training;
    
    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    public ModuleTrainingEntity() {
    	this.moduleTrainingPk = new ModuleTrainingPk();
    }

    public ModuleTrainingEntity(ModuleTrainingPk moduleTrainingPk) {
        this.moduleTrainingPk = moduleTrainingPk;
    }

    public ModuleTrainingEntity(int trainingPk, int modulePk) {
        this.moduleTrainingPk = new ModuleTrainingPk(trainingPk, modulePk);
    }

    public ModuleTrainingPk getModuleTrainingPk() {
        return moduleTrainingPk;
    }

    public void setModuleTrainingPk(ModuleTrainingPk moduleTrainingPk) {
        this.moduleTrainingPk = moduleTrainingPk;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public ModuleEntity getModule() {
        return module;
    }

    public void setModule(ModuleEntity module) {
        this.module = module;
    }

    public TrainingEntity getTraining() {
        return training;
    }

    public void setTraining(TrainingEntity training) {
        this.training = training;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (moduleTrainingPk != null ? moduleTrainingPk.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ModuleTrainingEntity)) {
            return false;
        }
        
        ModuleTrainingEntity other = (ModuleTrainingEntity) object;
        
        if ((this.moduleTrainingPk == null && other.moduleTrainingPk != null) || (this.moduleTrainingPk != null && !this.moduleTrainingPk.equals(other.moduleTrainingPk))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "ModuleTrainingEntity[moduleTrainingPK=" + moduleTrainingPk + "]";
    }
    
}
