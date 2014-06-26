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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 * TODO ENTITY JAVADOC
 * 
 * @author Dany Jupille
 */
@Entity
@NamedQueries({
	@NamedQuery(
			name = "SchoolQuery.getFounderOf",
			query = "SELECT e.user FROM EmployeeEntity e, SchoolEntity s, EmployeeTypeEntity et, EmployeeSchoolTypeEntity est"
					+ " WHERE s.schoolPk = :schoolPk AND et.name = 'founder'"
					+ " AND s = est.school AND e = est.employee AND et = est.employeeType")
})
@Table(name = "schools")
public class SchoolEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_school")
    private Integer schoolPk;
    
    @NotBlank(message = "Name cannot be empty")
    @Size(max = 50, message = "Name is too long (maximum 50 character)")
    @Column(name = "name")
    private String name;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    
    @ManyToMany(mappedBy = "schoolsList")
    private List<StudentEntity> studentsList = new ArrayList<>();
    
    @JoinTable(name = "events_schools", joinColumns = {
        @JoinColumn(name = "pk_school", referencedColumnName = "pk_school")}, inverseJoinColumns = {
        @JoinColumn(name = "pk_event", referencedColumnName = "pk_event")})
    @ManyToMany
    private List<EventEntity> eventsList = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
    private List<TrainingEntity> trainingsList = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
    private List<EmployeeSchoolTypeEntity> employeesSchoolsTypesList = new ArrayList<>();

    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    public SchoolEntity() {
    }

    public SchoolEntity(Integer schoolPk) {
        this.schoolPk = schoolPk;
    }

    public Integer getSchoolPk() {
        return schoolPk;
    }

    public void setSchoolPk(Integer schoolPk) {
        this.schoolPk = schoolPk;
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

    public List<StudentEntity> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<StudentEntity> studentsList) {
        this.studentsList = studentsList;
    }

    public List<EventEntity> getEventsList() {
        return eventsList;
    }

    public void setEventsList(List<EventEntity> eventsList) {
        this.eventsList = eventsList;
    }

    public List<TrainingEntity> getTrainingsList() {
        return trainingsList;
    }

    public void setTrainingsList(List<TrainingEntity> trainingsList) {
        this.trainingsList = trainingsList;
    }

    public List<EmployeeSchoolTypeEntity> getEmployeesSchoolsTypesList() {
        return employeesSchoolsTypesList;
    }

    public void setEmployeesSchoolsTypesList(List<EmployeeSchoolTypeEntity> employeesSchoolsTypesList) {
        this.employeesSchoolsTypesList = employeesSchoolsTypesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (schoolPk != null ? schoolPk.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SchoolEntity)) {
            return false;
        }
        
        SchoolEntity other = (SchoolEntity) object;
        
        if ((this.schoolPk == null && other.schoolPk != null) || (this.schoolPk != null && !this.schoolPk.equals(other.schoolPk))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "SchoolEntity[id=" + schoolPk + "]";
    }
}
