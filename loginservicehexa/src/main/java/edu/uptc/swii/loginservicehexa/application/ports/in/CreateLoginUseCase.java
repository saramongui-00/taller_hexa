package edu.uptc.swii.loginservicehexa.application.ports.in;

import edu.uptc.swii.loginservicehexa.domain.model.Login;

public interface CreateLoginUseCase {
    Login createLogin(Login login);
}
