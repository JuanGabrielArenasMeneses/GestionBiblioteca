package com.biblioteca.gestionBiblioteca.infrastructure.adapters;

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
class UserRepositoryAdapterTest {
    @InjectMocks
    private UserRepositoryAdapter userRepositoryAdapter;
    @Autowired
    IUserRepositoryAdapter repository;
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