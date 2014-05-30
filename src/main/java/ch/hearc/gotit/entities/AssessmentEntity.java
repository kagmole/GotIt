package ch.hearc.gotit.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 * TODO ENTITY JAVADOC
 * 
 * @author Dany Jupille
 */
@Entity
@Table(name = "assessments")
public class AssessmentEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_assessment")
    private Integer assessmentPk;
    
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    
    @Column(name = "assessment_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date assessmentDatetime;
    
    @Column(name = "marks_max")
    private Integer marksMax;
    
    @Column(name = "weight")
    private Float weight;
    
    @ManyToMany(mappedBy = "assessmentsList")
    private List<CourseEntity> coursesList;
    
    @JoinColumn(name = "pk_assessment_type", referencedColumnName = "pk_assessment_type")
    @ManyToOne(optional = false)
    private AssessmentTypeEntity assessmentType;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assessment")
    private List<AssessmentStudentEntity> assessmentsStudentsList;

    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    public AssessmentEntity() {
    }

    public AssessmentEntity(Integer assessmentPk) {
        this.assessmentPk = assessmentPk;
    }

    public Integer getAssessmentPk() {
        return assessmentPk;
    }

    public void setAssessmentPk(Integer assessmentPk) {
        this.assessmentPk = assessmentPk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAssessmentDatetime() {
        return assessmentDatetime;
    }

    public void setAssessmentDatetime(Date assessmentDatetime) {
        this.assessmentDatetime = assessmentDatetime;
    }

    public Integer getMarksMax() {
        return marksMax;
    }

    public void setMarksMax(Integer marksMax) {
        this.marksMax = marksMax;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public List<CourseEntity> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<CourseEntity> coursesList) {
        this.coursesList = coursesList;
    }

    public AssessmentTypeEntity getAssessmentType() {
        return assessmentType;
    }

    public void setAssessmentType(AssessmentTypeEntity assessmentType) {
        this.assessmentType = assessmentType;
    }

    public List<AssessmentStudentEntity> getAssessmentsStudentsList() {
        return assessmentsStudentsList;
    }

    public void setAssessmentsStudentsList(List<AssessmentStudentEntity> assessmentsStudentsList) {
        this.assessmentsStudentsList = assessmentsStudentsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (assessmentPk != null ? assessmentPk.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AssessmentEntity)) {
            return false;
        }
        
        AssessmentEntity other = (AssessmentEntity) object;
        
        if ((this.assessmentPk == null && other.assessmentPk != null) || (this.assessmentPk != null && !this.assessmentPk.equals(other.assessmentPk))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "AssessmentEntity[pk=" + assessmentPk + "]";
    }
}
