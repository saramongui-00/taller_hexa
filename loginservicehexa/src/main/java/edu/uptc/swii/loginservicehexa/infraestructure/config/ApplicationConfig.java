package edu.uptc.swii.loginservicehexa.infraestructure.config;

import edu.uptc.swii.loginservicehexa.application.ports.out.LoginRepositoryPort;
import edu.uptc.swii.loginservicehexa.application.services.LoginService;
import edu.uptc.swii.loginservicehexa.application.usecases.CreateLoginUseCaseImpl;
import edu.uptc.swii.loginservicehexa.application.usecases.DeleteLoginUseCaseImpl;
import edu.uptc.swii.loginservicehexa.application.usecases.FindLoginUseCaseImpl;
import edu.uptc.swii.loginservicehexa.application.usecases.UpdateLoginUseCaseImpl;
import edu.uptc.swii.loginservicehexa.infraestructure.repositories.JpaLoginRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public LoginService loginService (LoginRepositoryPort loginRepositoryPort){
        return new LoginService(
                new CreateLoginUseCaseImpl(loginRepositoryPort),
                new DeleteLoginUseCaseImpl(loginRepositoryPort),
                new FindLoginUseCaseImpl(loginRepositoryPort),
                new UpdateLoginUseCaseImpl(loginRepositoryPort));
    }

    @Bean
    public LoginRepositoryPort loginRepositoryPort(JpaLoginRepositoryAdapter jpaLoginRepositoryAdapter){
        return jpaLoginRepositoryAdapter;
    }
}
