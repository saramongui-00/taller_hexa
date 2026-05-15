package edu.uptc.swii.loginservicehexa.infraestructure.controllers;

import edu.uptc.swii.loginservicehexa.application.services.LoginService;
import edu.uptc.swii.loginservicehexa.domain.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/addlogin")
    public ResponseEntity<Login> createLogin(@RequestBody Login login){
        Login createdLogin = loginService.createLogin(login);
        return new ResponseEntity<>(createdLogin, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Login> getLoginById(@PathVariable Long id){
        return loginService.getLoginById(id)
                .map(login -> new ResponseEntity<>(login, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/alllogin")
    public ResponseEntity<List<Login>> findAllLogin(){
        List<Login> logins = loginService.findAllLogin();
        return new ResponseEntity<>(logins, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Login> updateLogin(@PathVariable Long id, @RequestBody Login loginUpdate){
        return loginService.updateLogin(id, loginUpdate)
                .map(login -> new ResponseEntity<>(login, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Login> deleteLoginById(@PathVariable Long id){
        if(loginService.deleteLogin(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
