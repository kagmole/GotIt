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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * TODO ENTITY JAVADOC
 * 
 * @author Dany Jupille
 */
@Entity
@Table(name = "assessments")
@XmlRootElement
public class AssessmentEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_assessment")
    private Integer id;
    
    @Size(max = 45)
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
    
    @JoinColumn(name = "id_assessment_type", referencedColumnName = "id_assessment_type")
    @ManyToOne(optional = false)
    private AssessmentTypeEntity assessmentType;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assessment")
    private List<AssessmentResultEntity> assessmentsResultsList;

    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    public AssessmentEntity() {
    }

    public AssessmentEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @XmlTransient
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

    @XmlTransient
    public List<AssessmentResultEntity> getAssessmentsResultsList() {
        return assessmentsResultsList;
    }

    public void setAssessmentsResultsList(List<AssessmentResultEntity> assessmentsResultsList) {
        this.assessmentsResultsList = assessmentsResultsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (id != null ? id.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AssessmentEntity)) {
            return false;
        }
        
        AssessmentEntity other = (AssessmentEntity) object;
        
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "AssessmentEntity[id=" + id + "]";
    }
}
