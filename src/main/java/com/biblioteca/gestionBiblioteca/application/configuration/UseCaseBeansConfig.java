package com.biblioteca.gestionBiblioteca.application.configuration;

import com.biblioteca.gestionBiblioteca.domain.model.gateway.IBookRepository;
import com.biblioteca.gestionBiblioteca.domain.model.gateway.ILoanRepository;
import com.biblioteca.gestionBiblioteca.domain.model.gateway.IUserRepository;
import com.biblioteca.gestionBiblioteca.domain.usecase.BookUseCase;
import com.biblioteca.gestionBiblioteca.domain.usecase.LoanUseCase;
import com.biblioteca.gestionBiblioteca.domain.usecase.UserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeansConfig {
    @Bean
    public BookUseCase bookUseCase(IBookRepository iBookRepository){
        return new BookUseCase(iBookRepository);
    }
    @Bean
    public LoanUseCase loanUseCase(ILoanRepository iLoanRepository){
        return new LoanUseCase(iLoanRepository);
    }
    @Bean
    public UserUseCase userUseCase(IUserRepository iUserRepository){
        return new UserUseCase(iUserRepository);
    }
}
