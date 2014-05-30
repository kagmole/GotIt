package ch.hearc.gotit.entities;

import ch.hearc.gotit.constraints.FieldEqualsConstraint;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * TODO ENTITY JAVADOC
 * 
 * @author Dany Jupille
 */
@Entity
@NamedQueries({
	@NamedQuery(
			name = "UserQuery.findByUsername",
			query = "SELECT u FROM UserEntity u WHERE u.username = :username")
})
@FieldEqualsConstraint.List({
	@FieldEqualsConstraint(first = "password", second = "confirmPassword", message = "Passwords don't match"),
	@FieldEqualsConstraint(first = "mainEmail", second = "confirmMainEmail", message = "Main emails don't match"),
	@FieldEqualsConstraint(first = "secondaryEmail", second = "confirmSecondaryEmail", message = "Secondary emails don't match")
})
@Table(name = "users")
public class UserEntity implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_user")
    private Integer userPk;
    
    @Size.List({
    	@Size(min = 4, message = "Username is too short (minimum 4 characters)"),
    	@Size(max = 50, message = "Username is too long (maximum 50 characters)")
    })
    @Column(name = "username")
    private String username;
    
    @Size.List({
    	@Size(min = 8, message = "Password is too short (minimum 8 characters)"),
    	@Size(max = 50, message = "Password is too long (maximum 50 characters)")
    })
    @Column(name = "password")
    private String password;
    
    @Transient
    private String confirmPassword;
    
    @Column(name = "enabled")
    private Boolean enabled;
    
    @NotBlank(message = "Firstname cannot be empty")
    @Size(max = 50, message = "Firstname is too long (maximum 50 characters)")
    @Column(name = "firstname")
    private String firstname;
    
    @NotBlank(message = "Lastname cannot be empty")
    @Size(max = 50, message = "Lastname is too long (maximum 50 characters)")
    @Column(name = "lastname")
    private String lastname;
    
    @NotBlank(message = "Main email cannot be empty")
    @Email(message = "Invalid main email format")
    @Size(max = 50, message = "Main email is too long (maximum 50 characters)")
    @Column(name = "main_email")
    private String mainEmail;
    
    @Transient
    private String confirmMainEmail;
    
    @Email(message = "Invalid secondary email format")
    @Size(max = 50, message = "Secondary email is too long (maximum 50 characters)")
    @Column(name = "secondary_email")
    private String secondaryEmail;
    
    @Transient
    private String confirmSecondaryEmail;
    
    @Size(max = 50, message = "Location is too long (maximum 50 characters)")
    @Column(name = "location")
    private String location;
    
    @Column(name = "home_phone")
    private String homePhone;
    
    @Column(name = "private_phone")
    private String privatePhone;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "biography")
    private String biography;
    
    @JoinColumn(name = "fk_authority", referencedColumnName = "pk_authority")
    @ManyToOne(optional = false)
    private AuthorityEntity authority;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private StudentEntity student;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private EmployeeEntity employee;

    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    public UserEntity() {
    }

    public UserEntity(Integer userPk) {
        this.userPk = userPk;
    }

    public Integer getUserPk() {
        return userPk;
    }

    public void setUserPk(Integer userPk) {
        this.userPk = userPk;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getConfirmPassword() {
    	return confirmPassword;
    }
    
    public void setConfirmPassword(String confirmPassword) {
    	this.confirmPassword = confirmPassword;
    }
    
    public Boolean isEnabled() {
    	return enabled;
    }
    
    public void setEnabled(Boolean enabled) {
    	this.enabled = enabled;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMainEmail() {
        return mainEmail;
    }

    public void setMainEmail(String mainEmail) {
        this.mainEmail = mainEmail;
    }
    
    public String getConfirmMainEmail() {
    	return confirmMainEmail;
    }
    
    public void setConfirmMainEmail(String confirmMainEmail) {
    	this.confirmMainEmail = confirmMainEmail;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }
    
    public String getConfirmSecondaryEmail() {
    	return confirmSecondaryEmail;
    }
    
    public void setConfirmSecondaryEmail(String confirmSecondaryEmail) {
    	this.confirmSecondaryEmail = confirmSecondaryEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getPrivatePhone() {
        return privatePhone;
    }

    public void setPrivatePhone(String privatePhone) {
        this.privatePhone = privatePhone;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
    
    public AuthorityEntity getAuthority() {
    	return authority;
    }
    
    public void setAuthority(AuthorityEntity authority) {
    	this.authority = authority;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
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
        
        hash += (userPk != null ? userPk.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof UserEntity)) {
            return false;
        }
        
        UserEntity other = (UserEntity) object;
        
        if ((this.userPk == null && other.userPk != null) || (this.userPk != null && !this.userPk.equals(other.userPk))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "UserEntity[id=" + userPk + "]";
    }
}
