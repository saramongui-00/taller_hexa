package edu.uptc.swii.loginservicehexa.application.ports.in;

import edu.uptc.swii.loginservicehexa.domain.model.Login;

import java.util.List;
import java.util.Optional;

public interface FindLoginUseCase {
    Optional<Login> getLoginById(Long id);
    List<Login> findAllLogin();
}
