package edu.uptc.swii.loginservicehexa.application.usecases;

import edu.uptc.swii.loginservicehexa.application.ports.in.FindLoginUseCase;
import edu.uptc.swii.loginservicehexa.application.ports.out.LoginRepositoryPort;
import edu.uptc.swii.loginservicehexa.domain.model.Login;

import java.util.List;
import java.util.Optional;

public class FindLoginUseCaseImpl implements FindLoginUseCase {
    private final LoginRepositoryPort loginRepositoryPort;

    public FindLoginUseCaseImpl(LoginRepositoryPort loginRepositoryPort) {
        this.loginRepositoryPort = loginRepositoryPort;
    }

    @Override
    public Optional<Login> getLoginById(Long id) {
        return loginRepositoryPort.findById(id);
    }

    @Override
    public List<Login> findAllLogin() {
        return loginRepositoryPort.findAll();
    }
}
