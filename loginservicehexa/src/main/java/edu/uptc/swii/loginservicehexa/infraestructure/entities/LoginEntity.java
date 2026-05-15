package edu.uptc.swii.loginservicehexa.infraestructure.entities;


import edu.uptc.swii.loginservicehexa.application.services.LoginService;
import edu.uptc.swii.loginservicehexa.domain.model.Login;
import jakarta.persistence.*;

@Entity
@Table(name = "login")
public class LoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "customerid")
    private String customerid;

    @Column(name = "password")
    private String password;

    public LoginEntity(){}

    public LoginEntity(Long id, String customerid, String password) {
        this.id = id;
        this.customerid = customerid;
        this.password = password;
    }

    public static LoginEntity fromDomainModel(Login login){
        return new LoginEntity(login.getId(), login.getCustomerid(), login.getPassword());
    }

    public Login toDomainModel(){
        return new Login(id, customerid, password);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}