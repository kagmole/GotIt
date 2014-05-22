package ch.hearc.gotit.entities.pks;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * TODO ENTITY JAVADOC
 * 
 * @author Dany Jupille
 */
@Embeddable
public class ModuleTrainingPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
    @NotNull
    @Column(name = "id_training")
    private int idTraining;
	
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_module")
    private int idModule;
    
    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    public ModuleTrainingPK() {
    }

    public ModuleTrainingPK(int idTraining, int idModule) {
        this.idTraining = idTraining;
        this.idModule = idModule;
    }

    public int getIdTraining() {
        return idTraining;
    }

    public void setIdTraining(int idTraining) {
        this.idTraining = idTraining;
    }

    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (int) idTraining;
        hash += (int) idModule;
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ModuleTrainingPK)) {
            return false;
        }
        
        ModuleTrainingPK other = (ModuleTrainingPK) object;
        
        if (this.idTraining != other.idTraining) {
            return false;
        }
        
        if (this.idModule != other.idModule) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "ModuleTrainingPK[idTraining=" + idTraining + ", idModule=" + idModule + "]";
    }
}
