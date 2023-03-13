package com.biblioteca.gestionBiblioteca.infrastructure.adapters;

import com.biblioteca.gestionBiblioteca.infrastructure.adapters.jpa.ILoanRepositoryAdapter;
import com.biblioteca.gestionBiblioteca.infrastructure.adapters.jpa.IUserRepositoryAdapter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
class LoanRepositoryAdapterTest {
    @InjectMocks
    private LoanRepositoryAdapter userRepositoryAdapter;
    @Autowired
    ILoanRepositoryAdapter repository;
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