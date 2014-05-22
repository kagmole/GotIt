package ch.hearc.gotit.entities;

import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * TODO ENTITY JAVADOC
 *
 * @author Dany Jupille
 */
@Entity
@Table(name = "trainings")
@XmlRootElement
public class TrainingEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_training")
    private Integer id;
    
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    
    @JoinTable(name = "events_trainings", joinColumns = {
        @JoinColumn(name = "id_training", referencedColumnName = "id_training")}, inverseJoinColumns = {
        @JoinColumn(name = "id_event", referencedColumnName = "id_event")})
    @ManyToMany
    private List<EventEntity> eventsList;
    
    @JoinColumn(name = "id_school", referencedColumnName = "id_school")
    @ManyToOne(optional = false)
    private SchoolEntity school;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "training")
    private List<ModuleTrainingEntity> modulesTrainingsList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "training")
    private List<StudentTrainingEntity> studentsTrainingsList;

    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    public TrainingEntity() {
    }

    public TrainingEntity(Integer id) {
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

    @XmlTransient
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

    @XmlTransient
    public List<ModuleTrainingEntity> getModulesTrainingsList() {
        return modulesTrainingsList;
    }

    public void setModulesTrainingsList(List<ModuleTrainingEntity> modulesTrainingsList) {
        this.modulesTrainingsList = modulesTrainingsList;
    }

    @XmlTransient
    public List<StudentTrainingEntity> getStudentsTrainingsList() {
        return studentsTrainingsList;
    }

    public void setStudentsTrainingsList(List<StudentTrainingEntity> studentsTrainingsList) {
        this.studentsTrainingsList = studentsTrainingsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (id != null ? id.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TrainingEntity)) {
            return false;
        }
        
        TrainingEntity other = (TrainingEntity) object;
        
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "TrainingEntity[id=" + id + "]";
    }
    
}
