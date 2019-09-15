package idealab.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name ="customer_info")
public class CustomerInfo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name="fk_email_hash_id", referencedColumnName = "id", nullable = false)    
    private EmailHash emailHashId;

    @Column(name = "first_name", nullable = false)
    @Length(min = 1, max = 254)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Length(min = 1,  max = 254)
    private String lastName;

    @Column(name = "email", nullable = false)
    @Length(min = 1,  max = 254)
    private String email;

    @JsonIgnore
    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    public CustomerInfo() {
        this.createdDate = Date.valueOf(LocalDate.now());
    }

    public CustomerInfo(EmailHash emailHashId, String firstName, String lastName, String email) {
        this.emailHashId = emailHashId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.createdDate = Date.valueOf(LocalDate.now());
    }

    //getters and setters
    public EmailHash getEmailHashId() {
        return emailHashId;
    }

    public void setEmailHashId(EmailHash emailHashId) {
        this.emailHashId = emailHashId;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}

