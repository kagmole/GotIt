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
import javax.persistence.Lob;
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
    @Column(name = "id_user")
    private Integer id;
    
    @Size.List({
    	@Size(min = 4, message = "Username is too short (minimum 4 characters)"),
    	@Size(max = 45, message = "Username is too long (maximum 45 characters)")
    })
    @Column(name = "username")
    private String username;
    
    @Size.List({
    	@Size(min = 8, message = "Password is too short (minimum 8 characters)"),
    	@Size(max = 45, message = "Password is too long (maximum 45 characters)")
    })
    @Column(name = "password")
    private String password;
    
    @Transient
    private String confirmPassword;
    
    @NotBlank(message = "Firstname cannot be empty")
    @Size(max = 45, message = "Firstname is too long (maximum 45 characters)")
    @Column(name = "firstname")
    private String firstname;
    
    @NotBlank(message = "Lastname cannot be empty")
    @Size(max = 45, message = "Lastname is too long (maximum 45 characters)")
    @Column(name = "lastname")
    private String lastname;
    
    @NotBlank(message = "Main email cannot be empty")
    @Email(message = "Invalid main email format")
    @Size(max = 45, message = "Main email is too long (maximum 45 characters)")
    @Column(name = "main_email")
    private String mainEmail;
    
    @Transient
    private String confirmMainEmail;
    
    @Email(message = "Invalid secondary email format")
    @Size(max = 45, message = "Secondary email is too long (maximum 45 characters)")
    @Column(name = "secondary_email")
    private String secondaryEmail;
    
    @Transient
    private String confirmSecondaryEmail;
    
    @Size(max = 45, message = "Location is too long (maximum 45 characters)")
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
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private StudentEntity student;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private EmployeeEntity employee;

    /**
     * TODO CONSTRUCTORS JAVADOC
     */
    public UserEntity() {
    }

    public UserEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployees(EmployeeEntity employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (id != null ? id.hashCode() : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof UserEntity)) {
            return false;
        }
        
        UserEntity other = (UserEntity) object;
        
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "UserEntity[id=" + id + "]";
    }
}
