package ch.hearc.gotit.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * TODO ENTITY JAVADOC
 * 
 * @author Dany Jupille
 */
@Entity
@Table(name = "assessments_types")
public class AssessmentTypeEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_assessment_type")
    private Integer assessmentTypePk;
    
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    
    @Column(name = "importance")
    private Integer importance;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assessmentType")
    private List<AssessmentEntity> assessmentsList = new ArrayList<>();

    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    public AssessmentTypeEntity() {
    }

    public AssessmentTypeEntity(Integer assessmentTypePk) {
        this.assessmentTypePk = assessmentTypePk;
    }

    public Integer getAssessmentTypePk() {
        return assessmentTypePk;
    }

    public void setAssessmentTypePk(Integer assessmentTypePk) {
        this.assessmentTypePk = assessmentTypePk;
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

    public Integer getImportance() {
        return importance;
    }

    public void setImportance(Integer importance) {
        this.importance = importance;
    }

    public List<AssessmentEntity> getAssessmentsList() {
        return assessmentsList;
    }

    public void setAssessmentsList(List<AssessmentEntity> assessmentsList) {
        this.assessmentsList = assessmentsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (assessmentTypePk != null ? assessmentTypePk.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AssessmentTypeEntity)) {
            return false;
        }
        
        AssessmentTypeEntity other = (AssessmentTypeEntity) object;
        
        if ((this.assessmentTypePk == null && other.assessmentTypePk != null) || (this.assessmentTypePk != null && !this.assessmentTypePk.equals(other.assessmentTypePk))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "AssessmentTypeEntity[id=" + assessmentTypePk + "]";
    }
}
