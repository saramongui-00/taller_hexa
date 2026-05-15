package edu.uptc.swii.loginservicehexa.infraestructure.repositories;

import edu.uptc.swii.loginservicehexa.infraestructure.entities.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaLoginRepository extends JpaRepository<LoginEntity, Long> {
}
