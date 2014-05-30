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
    private int employeePk;
	
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_school")
    private int schoolPk;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_employee_type")
    private int employeeTypePk;

    public EmployeeSchoolTypePk() {
    }

    public EmployeeSchoolTypePk(int employeePk, int schoolPk, int employeeTypePk) {
        this.employeePk = employeePk;
        this.schoolPk = schoolPk;
        this.employeeTypePk = employeeTypePk;
    }

    public int getEmployeePk() {
        return employeePk;
    }

    public void setEmployeePk(int employeePk) {
        this.employeePk = employeePk;
    }

    public int getSchoolPk() {
        return schoolPk;
    }

    public void setSchoolPk(int schoolPk) {
        this.schoolPk = schoolPk;
    }

    public int getEmployeeTypePk() {
        return employeeTypePk;
    }

    public void setEmployeeTypePk(int employeeTypePk) {
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
