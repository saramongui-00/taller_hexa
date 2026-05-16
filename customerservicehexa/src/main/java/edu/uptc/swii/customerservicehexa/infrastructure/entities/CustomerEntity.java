package edu.uptc.swii.customerservicehexa.infrastructure.entities;

import edu.uptc.swii.customerservicehexa.domain.model.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CustomerEntity {
    @Id
    private String document;
    private String firstname;
    private String lastname;
    private String address;
    private String phone;
    private String email;

    public CustomerEntity() {
    }

    public CustomerEntity(String document, String firstname, String lastname, String address, String phone,
            String email) {
        this.document = document;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public static CustomerEntity fromDomainModel(Customer customer) {
        return new CustomerEntity(customer.getDocument(), customer.getFirstname(), customer.getLastname(),
                customer.getAddress(), customer.getPhone(), customer.getEmail());
    }

    public Customer toDomainModel() {
        return new Customer(document, firstname, lastname, address, phone, email);
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
