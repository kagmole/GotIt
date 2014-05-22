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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * TODO ENTITY JAVADOC
 * 
 * @author Dany Jupille
 */
@Entity
@Table(name = "employees")
@XmlRootElement
public class EmployeeEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_employee")
    private Integer id;
    
    @JoinTable(name = "employees_courses", joinColumns = {
        @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")}, inverseJoinColumns = {
        @JoinColumn(name = "id_course", referencedColumnName = "id_course")})
    @ManyToMany
    private List<CourseEntity> coursesList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<EmployeeSchoolEntity> employeesSchoolsList;
    
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @OneToOne(optional = false)
    private UserEntity user;
    
    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    public EmployeeEntity() {
    }

    public EmployeeEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public List<CourseEntity> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<CourseEntity> coursesList) {
        this.coursesList = coursesList;
    }

    @XmlTransient
    public List<EmployeeSchoolEntity> getEmployeesSchoolsList() {
        return employeesSchoolsList;
    }

    public void setEmployeesSchoolsList(List<EmployeeSchoolEntity> employeesSchoolsList) {
        this.employeesSchoolsList = employeesSchoolsList;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (id != null ? id.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EmployeeEntity)) {
            return false;
        }
        
        EmployeeEntity other = (EmployeeEntity) object;
        
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "EmployeeEntity[id=" + id + "]";
    }
}
