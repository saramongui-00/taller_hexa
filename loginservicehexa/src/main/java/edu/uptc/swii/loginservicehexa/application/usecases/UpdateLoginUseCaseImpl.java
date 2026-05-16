package edu.uptc.swii.loginservicehexa.application.usecases;

import edu.uptc.swii.loginservicehexa.application.ports.in.UpdateLoginUseCase;
import edu.uptc.swii.loginservicehexa.application.ports.out.LoginRepositoryPort;
import edu.uptc.swii.loginservicehexa.domain.model.Login;

import java.util.Optional;

public class UpdateLoginUseCaseImpl implements UpdateLoginUseCase {
    private final LoginRepositoryPort loginRepositoryPort;

    public UpdateLoginUseCaseImpl(LoginRepositoryPort loginRepositoryPort) {
        this.loginRepositoryPort = loginRepositoryPort;
    }

    @Override
    public Optional<Login> updateLogin(Long id, Login updateLogin) {
        return loginRepositoryPort.update(id, updateLogin);
    }
}
