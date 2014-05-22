package ch.hearc.gotit.entities;

import ch.hearc.gotit.entities.pks.AssessmentResultPK;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * TODO ENTITY JAVADOC
 * 
 * @author Dany Jupille
 */
@Entity
@Table(name = "assessments_results")
@XmlRootElement
public class AssessmentResultEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected AssessmentResultPK assessmentResultPK;
    
    @Column(name = "marks")
    private Integer marks;
    
    @Size(max = 45)
    @Column(name = "grade")
    private String grade;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "comments")
    private String comments;
    
    @JoinColumn(name = "id_assessment", referencedColumnName = "id_assessment", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AssessmentEntity assessment;
    
    @JoinColumn(name = "id_student", referencedColumnName = "id_student", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private StudentEntity student;

    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    public AssessmentResultEntity() {
    }

    public AssessmentResultEntity(AssessmentResultPK assessmentResultPK) {
        this.assessmentResultPK = assessmentResultPK;
    }

    public AssessmentResultEntity(int idStudent, int idAssessment) {
        this.assessmentResultPK = new AssessmentResultPK(idStudent, idAssessment);
    }

    public AssessmentResultPK getAssessmentResultPK() {
        return assessmentResultPK;
    }

    public void setAssessmentResultPK(AssessmentResultPK assessmentResultPK) {
        this.assessmentResultPK = assessmentResultPK;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public AssessmentEntity getAssessment() {
        return assessment;
    }

    public void setAssessment(AssessmentEntity assessment) {
        this.assessment = assessment;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudents(StudentEntity student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (assessmentResultPK != null ? assessmentResultPK.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AssessmentResultEntity)) {
            return false;
        }
        
        AssessmentResultEntity other = (AssessmentResultEntity) object;
        
        if ((this.assessmentResultPK == null && other.assessmentResultPK != null) || (this.assessmentResultPK != null && !this.assessmentResultPK.equals(other.assessmentResultPK))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "AssessmentResultEntity[assessmentResultPK=" + assessmentResultPK + "]";
    }
}
