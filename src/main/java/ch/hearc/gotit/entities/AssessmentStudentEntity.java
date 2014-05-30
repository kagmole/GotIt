package ch.hearc.gotit.entities;

import ch.hearc.gotit.entities.pks.AssessmentStudentPk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * TODO ENTITY JAVADOC
 * 
 * @author Dany Jupille
 */
@Entity
@Table(name = "assessments_results")
public class AssessmentStudentEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected AssessmentStudentPk assessmentResultPK;
    
    @Column(name = "marks")
    private Integer marks;
    
    @Size(max = 50)
    @Column(name = "grade")
    private String grade;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "comments")
    private String comments;
    
    @MapsId("assessmentPk")
    @JoinColumn(name = "pk_assessment", referencedColumnName = "pk_assessment", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AssessmentEntity assessment;
    
    @MapsId("studentPk")
    @JoinColumn(name = "pk_student", referencedColumnName = "pk_student", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private StudentEntity student;

    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    public AssessmentStudentEntity() {
    }

    public AssessmentStudentEntity(AssessmentStudentPk assessmentResultPK) {
        this.assessmentResultPK = assessmentResultPK;
    }

    public AssessmentStudentEntity(int idStudent, int idAssessment) {
        this.assessmentResultPK = new AssessmentStudentPk(idStudent, idAssessment);
    }

    public AssessmentStudentPk getAssessmentResultPK() {
        return assessmentResultPK;
    }

    public void setAssessmentResultPK(AssessmentStudentPk assessmentResultPK) {
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
        if (!(object instanceof AssessmentStudentEntity)) {
            return false;
        }
        
        AssessmentStudentEntity other = (AssessmentStudentEntity) object;
        
        if ((this.assessmentResultPK == null && other.assessmentResultPK != null) || (this.assessmentResultPK != null && !this.assessmentResultPK.equals(other.assessmentResultPK))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
    	// TODO enhance for all toString of entities
        return "AssessmentResultEntity[pk=" + assessmentResultPK + "]";
    }
}
