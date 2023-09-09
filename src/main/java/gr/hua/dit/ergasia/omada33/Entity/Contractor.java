package gr.hua.dit.ergasia.omada33.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contractor")
public class Contractor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    //@NotBlank(message = "Please enter the first name")
    //@Size(max = 30)
    private String firstName;

    @Column(name = "last_name")
    //@Size(max = 30)
    private String lastName;

    @Column(name="email", unique = true)
    //@Size(max = 30)
    private String email;

    @OneToOne(mappedBy="contractor",fetch = FetchType.EAGER,
            cascade= {CascadeType.PERSIST, /*CascadeType.MERGE,*/
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JsonIgnore
    private Contract contract;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Contractor(){

    }

    public Contractor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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


    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }


    @JsonIgnore
    private String propertyName;

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }


    @Override
    public String toString() {
        return "Contractor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + "]";
    }

}