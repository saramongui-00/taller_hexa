package edu.uptc.swii.loginservicehexa.domain.model;

public class Login {
    private Long id;
    private String customerid;
    private String password;

    public Login(Long id, String customerid, String password) {
        this.id = id;
        this.customerid = customerid;
        this.password = password;
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
