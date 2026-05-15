package edu.uptc.swii.loginservicehexa.application.ports.in;

import edu.uptc.swii.loginservicehexa.domain.model.Login;

import java.util.Optional;

public interface UpdateLoginUseCase {
    Optional<Login> updateLogin(Long id, Login updateLogin);
}
