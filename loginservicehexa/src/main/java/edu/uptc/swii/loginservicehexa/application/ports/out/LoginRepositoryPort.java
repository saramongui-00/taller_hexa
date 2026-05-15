package edu.uptc.swii.loginservicehexa.application.ports.out;

import edu.uptc.swii.loginservicehexa.domain.model.Login;

import java.util.List;
import java.util.Optional;

public interface LoginRepositoryPort {
    Login save(Login login);
    Optional<Login> findById(Long id);
    List<Login> findAll();
    Optional<Login> update(Long id,Login login);
    boolean deleteById (Long id);
}
