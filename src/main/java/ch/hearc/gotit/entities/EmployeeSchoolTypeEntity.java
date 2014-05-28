package ch.hearc.gotit.entities;

import ch.hearc.gotit.entities.pks.EmployeeSchoolTypePk;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TODO ENTITY JAVADOC
 * 
 * @author Dany Jupille
 */
@Entity
@Table(name = "employees_schools_types")
public class EmployeeSchoolTypeEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected EmployeeSchoolTypePk employeeSchoolTypePk;
    
    @JoinColumn(name = "pk_employee", referencedColumnName = "pk_employee", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EmployeeEntity employee;
    
    @JoinColumn(name = "pk_school", referencedColumnName = "pk_school", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SchoolEntity school;
    
    @JoinColumn(name = "pk_employee_type", referencedColumnName = "pk_employee_type", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EmployeeTypeEntity employeeType;

    /**
     * TODO CONSTRUCTORS JAVADOC    
     */
    public EmployeeSchoolTypeEntity() {
    }

    public EmployeeSchoolTypeEntity(EmployeeSchoolTypePk employeeSchoolTypePk) {
        this.employeeSchoolTypePk = employeeSchoolTypePk;
    }

    public EmployeeSchoolTypeEntity(int employeePk, int schoolPk, int employeeTypePk) {
        this.employeeSchoolTypePk = new EmployeeSchoolTypePk(employeePk, schoolPk, employeeTypePk);
    }

    public EmployeeSchoolTypePk getEmployeeSchoolTypePk() {
        return employeeSchoolTypePk;
    }

    public void setEmployeeSchoolTypePk(EmployeeSchoolTypePk employeeSchoolTypePk) {
        this.employeeSchoolTypePk = employeeSchoolTypePk;
    }
    
    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }
    
    public SchoolEntity getSchool() {
        return school;
    }

    public void setSchool(SchoolEntity school) {
        this.school = school;
    }

    public EmployeeTypeEntity getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeTypeEntity employeeType) {
        this.employeeType = employeeType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (employeeSchoolTypePk != null ? employeeSchoolTypePk.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EmployeeSchoolTypeEntity)) {
            return false;
        }
        
        EmployeeSchoolTypeEntity other = (EmployeeSchoolTypeEntity) object;
        
        if ((this.employeeSchoolTypePk == null && other.employeeSchoolTypePk != null) || (this.employeeSchoolTypePk != null && !this.employeeSchoolTypePk.equals(other.employeeSchoolTypePk))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "EmployeeSchoolEntity[employeeSchoolPK=" + employeeSchoolTypePk + "]";
    }
}
