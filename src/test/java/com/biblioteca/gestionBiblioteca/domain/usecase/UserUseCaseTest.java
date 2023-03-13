package com.biblioteca.gestionBiblioteca.domain.usecase;

import com.biblioteca.gestionBiblioteca.domain.model.gateway.IBookRepository;
import com.biblioteca.gestionBiblioteca.domain.model.gateway.IUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserUseCaseTest {
    @InjectMocks
    private BookUseCase bookUseCase;
    @Mock
    private IUserRepository iUserRepository;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("")
    void saveUser() {
        //Arrange

        //Act

        //Assert

    }

    @Test
    @DisplayName("")
    void updateUser() {
        //Arrange

        //Act

        //Assert

    }

    @Test
    @DisplayName("")
    void findUserById() {
        //Arrange

        //Act

        //Assert

    }

    @Test
    @DisplayName("")
    void findAllUsers() {
        //Arrange

        //Act

        //Assert

    }

    @Test
    @DisplayName("")
    void deleteUser() {
        //Arrange

        //Act

        //Assert

    }
}