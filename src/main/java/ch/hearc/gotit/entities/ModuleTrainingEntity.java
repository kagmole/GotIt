package ch.hearc.gotit.entities;

import ch.hearc.gotit.entities.pks.ModuleTrainingPK;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * TODO ENTITY JAVADOC
 * 
 * @author Dany Jupille
 */
@Entity
@Table(name = "modules_trainings")
@XmlRootElement
public class ModuleTrainingEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected ModuleTrainingPK moduleTrainingPK;
    
    @Column(name = "weight")
    private Float weight;
    
    @JoinColumn(name = "id_module", referencedColumnName = "id_module", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ModuleEntity module;
    
    @JoinColumn(name = "id_training", referencedColumnName = "id_training", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TrainingEntity training;
    
    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    public ModuleTrainingEntity() {
    }

    public ModuleTrainingEntity(ModuleTrainingPK moduleTrainingPK) {
        this.moduleTrainingPK = moduleTrainingPK;
    }

    public ModuleTrainingEntity(int idTraining, int idModule) {
        this.moduleTrainingPK = new ModuleTrainingPK(idTraining, idModule);
    }

    public ModuleTrainingPK getModuleTrainingPK() {
        return moduleTrainingPK;
    }

    public void setModuleTrainingPK(ModuleTrainingPK moduleTrainingPK) {
        this.moduleTrainingPK = moduleTrainingPK;
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
        
        hash += (moduleTrainingPK != null ? moduleTrainingPK.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ModuleTrainingEntity)) {
            return false;
        }
        
        ModuleTrainingEntity other = (ModuleTrainingEntity) object;
        
        if ((this.moduleTrainingPK == null && other.moduleTrainingPK != null) || (this.moduleTrainingPK != null && !this.moduleTrainingPK.equals(other.moduleTrainingPK))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "ModuleTrainingEntity[moduleTrainingPK=" + moduleTrainingPK + "]";
    }
    
}
