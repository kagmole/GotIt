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
@Table(name = "employees_types")
public class EmployeeTypeEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_employee_type")
    private Integer employeeTypePk;
    
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeType")
    private List<EmployeeSchoolTypeEntity> employeesSchoolsList;

    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    public EmployeeTypeEntity() {
    }

    public EmployeeTypeEntity(Integer employeeTypePk) {
        this.employeeTypePk = employeeTypePk;
    }

    public Integer getEmployeeTypePk() {
        return employeeTypePk;
    }

    public void setEmployeeTypePk(Integer employeeTypePk) {
        this.employeeTypePk = employeeTypePk;
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

    public List<EmployeeSchoolTypeEntity> getEmployeesSchoolsList() {
        return employeesSchoolsList;
    }

    public void setEmployeesSchoolsList(List<EmployeeSchoolTypeEntity> employeesSchoolsList) {
        this.employeesSchoolsList = employeesSchoolsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (employeeTypePk != null ? employeeTypePk.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EmployeeTypeEntity)) {
            return false;
        }
        
        EmployeeTypeEntity other = (EmployeeTypeEntity) object;
        
        if ((this.employeeTypePk == null && other.employeeTypePk != null) || (this.employeeTypePk != null && !this.employeeTypePk.equals(other.employeeTypePk))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "EmployeeTypeEntity[id=" + employeeTypePk + "]";
    }
}
