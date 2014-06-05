package ch.hearc.gotit.entities.pks;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * TODO ENTITY JAVADOC
 * 
 * @author Dany Jupille
 */
@Embeddable
public class EmployeeSchoolTypePk implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
    @NotNull
    @Column(name = "pk_employee")
    private Integer employeePk;
	
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_school")
    private Integer schoolPk;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_employee_type")
    private Integer employeeTypePk;

    public EmployeeSchoolTypePk() {
    }

    public EmployeeSchoolTypePk(int employeePk, int schoolPk, int employeeTypePk) {
        this.employeePk = employeePk;
        this.schoolPk = schoolPk;
        this.employeeTypePk = employeeTypePk;
    }

    public Integer getEmployeePk() {
        return employeePk;
    }

    public void setEmployeePk(Integer employeePk) {
        this.employeePk = employeePk;
    }

    public Integer getSchoolPk() {
        return schoolPk;
    }

    public void setSchoolPk(Integer schoolPk) {
        this.schoolPk = schoolPk;
    }

    public Integer getEmployeeTypePk() {
        return employeeTypePk;
    }

    public void setEmployeeTypePk(Integer employeeTypePk) {
        this.employeeTypePk = employeeTypePk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (int) employeePk;
        hash += (int) schoolPk;
        hash += (int) employeeTypePk;
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EmployeeSchoolTypePk)) {
            return false;
        }
        
        EmployeeSchoolTypePk other = (EmployeeSchoolTypePk) object;
        
        if (this.employeePk != other.employeePk) {
            return false;
        }
        
        if (this.schoolPk != other.schoolPk) {
            return false;
        }
        
        if (this.employeeTypePk != other.employeeTypePk) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "EmployeeSchoolPK[idEmployee=" + employeePk + ", idSchool=" + schoolPk + ", idEmployeeType=" + employeeTypePk + "]";
    }
}
