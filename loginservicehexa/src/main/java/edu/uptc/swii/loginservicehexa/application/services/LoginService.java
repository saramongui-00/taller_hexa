package edu.uptc.swii.loginservicehexa.application.services;

import edu.uptc.swii.loginservicehexa.application.ports.in.CreateLoginUseCase;
import edu.uptc.swii.loginservicehexa.application.ports.in.DeleteLoginUseCase;
import edu.uptc.swii.loginservicehexa.application.ports.in.FindLoginUseCase;
import edu.uptc.swii.loginservicehexa.application.ports.in.UpdateLoginUseCase;
import edu.uptc.swii.loginservicehexa.domain.model.Login;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService implements CreateLoginUseCase, DeleteLoginUseCase, FindLoginUseCase, UpdateLoginUseCase {
    private final CreateLoginUseCase createLoginUseCase;
    private final DeleteLoginUseCase deleteLoginUseCase;
    private final FindLoginUseCase findLoginUseCase;
    private final UpdateLoginUseCase updateLoginUseCase;

    public LoginService(CreateLoginUseCase createLoginUseCase, DeleteLoginUseCase deleteLoginUseCase, FindLoginUseCase findLoginUseCase, UpdateLoginUseCase updateLoginUseCase) {
        this.createLoginUseCase = createLoginUseCase;
        this.deleteLoginUseCase = deleteLoginUseCase;
        this.findLoginUseCase = findLoginUseCase;
        this.updateLoginUseCase = updateLoginUseCase;
    }

    @Override
    public Login createLogin(Login login) {
        return createLoginUseCase.createLogin(login);
    }

    @Override
    public boolean deleteLogin(Long id) {
        return deleteLoginUseCase.deleteLogin(id);
    }

    @Override
    public Optional<Login> getLoginById(Long id) {
        return findLoginUseCase.getLoginById(id);
    }

    @Override
    public List<Login> findAllLogin() {
        return findLoginUseCase.findAllLogin();
    }

    @Override
    public Optional<Login> updateLogin(Long id, Login updateLogin) {
        return updateLoginUseCase.updateLogin(id, updateLogin);
    }
}
