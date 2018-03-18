/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Stefan
 */
@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    private Address address;
    @OneToMany(mappedBy = "Person", cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Person_id")
    private List<Phone> phoneList = new ArrayList();

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Hobby> hobbies;

    public Person(String firstName, String lastName, Address address, List<Hobby> hobbies) {
        this.hobbies = hobbies;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, Long id, List<Hobby> hobbies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.hobbies = hobbies;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Person[ id=" + id + " ]";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public List<Hobby> getHobbys() {
        return hobbies;
    }

}
