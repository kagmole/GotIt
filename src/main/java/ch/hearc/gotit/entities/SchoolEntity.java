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
@Table(name = "schools")
@XmlRootElement
public class SchoolEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_school")
    private Integer id;
    
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    
    @ManyToMany(mappedBy = "schoolsList")
    private List<StudentEntity> studentsList;
    
    @JoinTable(name = "events_schools", joinColumns = {
        @JoinColumn(name = "id_school", referencedColumnName = "id_school")}, inverseJoinColumns = {
        @JoinColumn(name = "id_event", referencedColumnName = "id_event")})
    @ManyToMany
    private List<EventEntity> eventsList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private List<TrainingEntity> trainingsList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
    private List<EmployeeSchoolEntity> employeesSchoolsList;

    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    public SchoolEntity() {
    }

    public SchoolEntity(Integer id) {
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
    public List<StudentEntity> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<StudentEntity> studentsList) {
        this.studentsList = studentsList;
    }

    @XmlTransient
    public List<EventEntity> getEventsList() {
        return eventsList;
    }

    public void setEventsList(List<EventEntity> eventsList) {
        this.eventsList = eventsList;
    }

    @XmlTransient
    public List<TrainingEntity> getTrainingsList() {
        return trainingsList;
    }

    public void setTrainingsList(List<TrainingEntity> trainingsList) {
        this.trainingsList = trainingsList;
    }

    @XmlTransient
    public List<EmployeeSchoolEntity> getEmployeesSchoolsList() {
        return employeesSchoolsList;
    }

    public void setEmployeesSchoolsList(List<EmployeeSchoolEntity> employeesSchoolsList) {
        this.employeesSchoolsList = employeesSchoolsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (id != null ? id.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SchoolEntity)) {
            return false;
        }
        
        SchoolEntity other = (SchoolEntity) object;
        
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "SchoolEntity[id=" + id + "]";
    }
}
