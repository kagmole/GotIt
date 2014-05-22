package ch.hearc.gotit.entities;

import ch.hearc.gotit.entities.pks.EmployeeSchoolPK;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * TODO ENTITY JAVADOC
 * 
 * @author Dany Jupille
 */
@Entity
@Table(name = "employees_schools")
@XmlRootElement
public class EmployeeSchoolEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected EmployeeSchoolPK employeeSchoolPK;
    
    @JoinColumn(name = "id_employee_type", referencedColumnName = "id_employee_type", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EmployeeTypeEntity employeeType;
    
    @JoinColumn(name = "id_school", referencedColumnName = "id_school", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SchoolEntity school;
    
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EmployeeEntity employee;

    /**
     * TODO CONSTRUCTORS JAVADOC    
     */
    public EmployeeSchoolEntity() {
    }

    public EmployeeSchoolEntity(EmployeeSchoolPK employeeSchoolPK) {
        this.employeeSchoolPK = employeeSchoolPK;
    }

    public EmployeeSchoolEntity(int idEmployee, int idSchool, int idEmployeeType) {
        this.employeeSchoolPK = new EmployeeSchoolPK(idEmployee, idSchool, idEmployeeType);
    }

    public EmployeeSchoolPK getEmployeeSchoolPK() {
        return employeeSchoolPK;
    }

    public void setEmployeeSchoolPK(EmployeeSchoolPK employeeSchoolPK) {
        this.employeeSchoolPK = employeeSchoolPK;
    }

    public EmployeeTypeEntity getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeTypeEntity employeeType) {
        this.employeeType = employeeType;
    }

    public SchoolEntity getSchool() {
        return school;
    }

    public void setSchool(SchoolEntity school) {
        this.school = school;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (employeeSchoolPK != null ? employeeSchoolPK.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EmployeeSchoolEntity)) {
            return false;
        }
        
        EmployeeSchoolEntity other = (EmployeeSchoolEntity) object;
        
        if ((this.employeeSchoolPK == null && other.employeeSchoolPK != null) || (this.employeeSchoolPK != null && !this.employeeSchoolPK.equals(other.employeeSchoolPK))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "EmployeeSchoolEntity[employeeSchoolPK=" + employeeSchoolPK + "]";
    }
}
