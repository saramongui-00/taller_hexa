package edu.uptc.swii.loginservicehexa.application.usecases;

import edu.uptc.swii.loginservicehexa.application.ports.in.CreateLoginUseCase;
import edu.uptc.swii.loginservicehexa.application.ports.out.LoginRepositoryPort;
import edu.uptc.swii.loginservicehexa.domain.model.Login;

public class CreateLoginUseCaseImpl implements CreateLoginUseCase {
    private final LoginRepositoryPort loginRepositoryPort;

    public CreateLoginUseCaseImpl(LoginRepositoryPort loginRepositoryPort) {
        this.loginRepositoryPort = loginRepositoryPort;
    }

    @Override
    public Login createLogin(Login login) {
        return loginRepositoryPort.save(login);
    }
}
