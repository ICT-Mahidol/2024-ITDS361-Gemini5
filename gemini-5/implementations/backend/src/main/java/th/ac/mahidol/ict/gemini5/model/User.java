package th.ac.mahidol.ict.gemini5.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "First name cannot be empty")
    @Column(unique = true)
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty")
    @Column(nullable = false)
    private String lastName;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    @Column(nullable = false)
    private String email;

    @NotEmpty(message = "Username cannot be empty")
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String phone;

    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 8, message = "Minimum password length is 8 characters")
    @Column(nullable = false)
    private String password;

    @NotEmpty(message = "role cannot be empty")
    @Column(nullable = false)
    private String role;

    @Transient 
    private String confirmPassword;
    
    public User() {
        super();
    }

    public User(String firstName, String lastName, String email, String username, String phone, String password, String confirmPassword, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.phone = phone;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getconfirmPassword() {
        return confirmPassword;
    }
    public void setconfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "Gemini User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", password='********'" +
                ", confirmPassword='********'" +
                '}';
    }

}
