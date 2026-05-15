package edu.uptc.swii.loginservicehexa.application.usecases;

import edu.uptc.swii.loginservicehexa.application.ports.in.DeleteLoginUseCase;
import edu.uptc.swii.loginservicehexa.application.ports.out.LoginRepositoryPort;

public class DeleteLoginUseCaseImpl implements DeleteLoginUseCase {
    private final LoginRepositoryPort loginRepositoryPort;

    public DeleteLoginUseCaseImpl(LoginRepositoryPort loginRepositoryPort) {
        this.loginRepositoryPort = loginRepositoryPort;
    }

    @Override
    public boolean deleteLogin(Long id) {
        return loginRepositoryPort.deleteById(id);
    }
}
