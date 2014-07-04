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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * TODO ENTITY JAVADOC
 *
 * @author Dany Jupille
 */
@Entity
@NamedQueries({
	@NamedQuery(
			name = "TrainingQuery.findRangeWithSchool",
			query = "SELECT trainingEntity"
					+ " FROM TrainingEntity trainingEntity"
					+ " WHERE trainingEntity.school.schoolPk = :schoolPk")
})
@Table(name = "trainings")
public class TrainingEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_training")
    private Integer trainingPk;
    
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    
    @JoinTable(name = "events_trainings", joinColumns = {
        @JoinColumn(name = "pk_training", referencedColumnName = "pk_training")}, inverseJoinColumns = {
        @JoinColumn(name = "pk_event", referencedColumnName = "pk_event")})
    @ManyToMany
    private List<EventEntity> eventsList = new ArrayList<>();
    
    @JoinColumn(name = "fk_school", referencedColumnName = "pk_school")
    @ManyToOne(optional = false)
    private SchoolEntity school;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "training")
    private List<ModuleTrainingEntity> modulesTrainingsList = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "training")
    private List<StudentTrainingEntity> studentsTrainingsList = new ArrayList<>();

    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    public TrainingEntity() {
    }

    public TrainingEntity(Integer trainingPk) {
        this.trainingPk = trainingPk;
    }

    public Integer getTrainingPk() {
        return trainingPk;
    }

    public void setTrainingPk(Integer trainingPk) {
        this.trainingPk = trainingPk;
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

    public List<EventEntity> getEventsList() {
        return eventsList;
    }

    public void setEventsList(List<EventEntity> eventsList) {
        this.eventsList = eventsList;
    }

    public SchoolEntity getSchool() {
        return school;
    }

    public void setSchool(SchoolEntity school) {
        this.school = school;
    }

    public List<ModuleTrainingEntity> getModulesTrainingsList() {
        return modulesTrainingsList;
    }

    public void setModulesTrainingsList(List<ModuleTrainingEntity> modulesTrainingsList) {
        this.modulesTrainingsList = modulesTrainingsList;
    }

    public List<StudentTrainingEntity> getStudentsTrainingsList() {
        return studentsTrainingsList;
    }

    public void setStudentsTrainingsList(List<StudentTrainingEntity> studentsTrainingsList) {
        this.studentsTrainingsList = studentsTrainingsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (trainingPk != null ? trainingPk.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TrainingEntity)) {
            return false;
        }
        
        TrainingEntity other = (TrainingEntity) object;
        
        if ((this.trainingPk == null && other.trainingPk != null) || (this.trainingPk != null && !this.trainingPk.equals(other.trainingPk))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "TrainingEntity[id=" + trainingPk + "]";
    }
}
