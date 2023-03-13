package com.biblioteca.gestionBiblioteca.domain.usecase;

import com.biblioteca.gestionBiblioteca.domain.model.gateway.IBookRepository;
import com.biblioteca.gestionBiblioteca.domain.model.gateway.ILoanRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class LoanUseCaseTest {
    @InjectMocks
    private LoanUseCase loanUseCase;
    @Mock
    private ILoanRepository iLoanRepository;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("")
    void saveLoan() {
        //Arrange

        //Act

        //Assert

    }

    @Test
    @DisplayName("")
    void updateLoan() {
        //Arrange

        //Act

        //Assert

    }

    @Test
    @DisplayName("")
    void findLoanById() {
        //Arrange

        //Act

        //Assert

    }

    @Test
    @DisplayName("")
    void findAllLoans() {
        //Arrange

        //Act

        //Assert

    }

    @Test
    @DisplayName("")
    void deleteLoan() {
        //Arrange

        //Act

        //Assert

    }
}