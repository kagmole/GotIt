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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * TODO ENTITY JAVADOC
 * 
 * @author Dany Jupille
 */
@Entity
@NamedQueries({
	@NamedQuery(
			name = "EmployeeQuery.findRangeWithSchool",
			query = "SELECT DISTINCT employeeSchoolTypeEntity.employee"
					+ " FROM EmployeeSchoolTypeEntity employeeSchoolTypeEntity"
					+ " WHERE employeeSchoolTypeEntity.school.schoolPk = :schoolPk")
})
@Table(name = "employees")
public class EmployeeEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_employee")
    private Integer employeePk;
    
    @JoinTable(name = "employees_courses", joinColumns = {
        @JoinColumn(name = "pk_employee", referencedColumnName = "pk_employee")}, inverseJoinColumns = {
        @JoinColumn(name = "pk_course", referencedColumnName = "pk_course")})
    @ManyToMany
    private List<CourseEntity> coursesList = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<EmployeeSchoolTypeEntity> employeesSchoolsTypesList = new ArrayList<>();
    
    @JoinColumn(name = "fk_user", referencedColumnName = "pk_user")
    @OneToOne(optional = false)
    private UserEntity user;
    
    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    public EmployeeEntity() {
    }

    public EmployeeEntity(Integer employeePk) {
        this.employeePk = employeePk;
    }

    public Integer getEmployeePk() {
        return employeePk;
    }

    public void setEmployeePk(Integer employeePk) {
        this.employeePk = employeePk;
    }

    public List<CourseEntity> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<CourseEntity> coursesList) {
        this.coursesList = coursesList;
    }

    public List<EmployeeSchoolTypeEntity> getEmployeesSchoolsTypesList() {
        return employeesSchoolsTypesList;
    }

    public void setEmployeesSchoolsTypesList(List<EmployeeSchoolTypeEntity> employeesSchoolsTypesList) {
        this.employeesSchoolsTypesList = employeesSchoolsTypesList;
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
        
        hash += (employeePk != null ? employeePk.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EmployeeEntity)) {
            return false;
        }
        
        EmployeeEntity other = (EmployeeEntity) object;
        
        if ((this.employeePk == null && other.employeePk != null) || (this.employeePk != null && !this.employeePk.equals(other.employeePk))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "EmployeeEntity[id=" + employeePk + "]";
    }
}
