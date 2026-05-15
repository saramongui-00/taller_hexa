package edu.uptc.swii.loginservicehexa.infraestructure.repositories;

import edu.uptc.swii.loginservicehexa.application.ports.out.LoginRepositoryPort;
import edu.uptc.swii.loginservicehexa.domain.model.Login;
import edu.uptc.swii.loginservicehexa.infraestructure.entities.LoginEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaLoginRepositoryAdapter implements LoginRepositoryPort {

    private final JpaLoginRepository jpaLoginRepository;

    public JpaLoginRepositoryAdapter(JpaLoginRepository jpaLoginRepository) {
        this.jpaLoginRepository = jpaLoginRepository;
    }

    @Override
    public Login save(Login login) {
        LoginEntity loginEntity = LoginEntity.fromDomainModel(login);
        LoginEntity savedLoginEntity = jpaLoginRepository.save(loginEntity);
        return savedLoginEntity.toDomainModel();
    }

    @Override
    public Optional<Login> findById(Long id) {
        return jpaLoginRepository.findById(id).map(LoginEntity::toDomainModel);
    }

    @Override
    public List<Login> findAll() {
        return jpaLoginRepository.findAll().stream()
                .map(LoginEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Login> update(Long id, Login login) {
        if (jpaLoginRepository.existsById(login.getId())){
            LoginEntity loginEntity = LoginEntity.fromDomainModel(login);
            LoginEntity updatedLoginEntity = jpaLoginRepository.save(loginEntity);
            return Optional.of(updatedLoginEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaLoginRepository.existsById(id)){
            jpaLoginRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
