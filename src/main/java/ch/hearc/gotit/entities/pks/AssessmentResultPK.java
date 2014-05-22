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
public class AssessmentResultPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
    @NotNull
    @Column(name = "id_student")
    private int idStudent;
	
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_assessment")
    private int idAssessment;

    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    public AssessmentResultPK() {
    }

    public AssessmentResultPK(int idStudent, int idAssessment) {
        this.idStudent = idStudent;
        this.idAssessment = idAssessment;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdAssessment() {
        return idAssessment;
    }

    public void setIdAssessment(int idAssessment) {
        this.idAssessment = idAssessment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (int) idStudent;
        hash += (int) idAssessment;
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AssessmentResultPK)) {
            return false;
        }
        
        AssessmentResultPK other = (AssessmentResultPK) object;
        
        if (this.idStudent != other.idStudent) {
            return false;
        }
        
        if (this.idAssessment != other.idAssessment) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "AssessmentResultPK[idStudent=" + idStudent + ", idAssessment=" + idAssessment + "]";
    }
}
