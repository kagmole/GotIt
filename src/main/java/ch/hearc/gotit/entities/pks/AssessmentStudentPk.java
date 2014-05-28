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
public class AssessmentStudentPk implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
    @NotNull
    @Column(name = "pk_student")
    private int studentPk;
	
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_assessment")
    private int assessmentPk;

    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    public AssessmentStudentPk() {
    }

    public AssessmentStudentPk(int studentPk, int assessmentPk) {
        this.studentPk = studentPk;
        this.assessmentPk = assessmentPk;
    }

    public int getStudentPk() {
        return studentPk;
    }

    public void setStudentPk(int studentPk) {
        this.studentPk = studentPk;
    }

    public int getAssessmentPk() {
        return assessmentPk;
    }

    public void setAssessmentPk(int assessmentPk) {
        this.assessmentPk = assessmentPk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (int) studentPk;
        hash += (int) assessmentPk;
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AssessmentStudentPk)) {
            return false;
        }
        
        AssessmentStudentPk other = (AssessmentStudentPk) object;
        
        if (this.studentPk != other.studentPk) {
            return false;
        }
        
        if (this.assessmentPk != other.assessmentPk) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "AssessmentResultPK[idStudent=" + studentPk + ", idAssessment=" + assessmentPk + "]";
    }
}
