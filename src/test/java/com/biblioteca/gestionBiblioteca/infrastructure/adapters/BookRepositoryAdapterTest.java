package com.biblioteca.gestionBiblioteca.infrastructure.adapters;

import com.biblioteca.gestionBiblioteca.infrastructure.adapters.jpa.IBookRepositoryAdapter;
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
class BookRepositoryAdapterTest {
    @InjectMocks
    private BookRepositoryAdapter bookRepositoryAdapter;
    @Autowired
    IBookRepositoryAdapter repository;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("")
    void saveBook() {
        //Arrange

        //Act

        //Assert

    }

    @Test
    @DisplayName("")
    void updateBook() {
        //Arrange

        //Act

        //Assert

    }

    @Test
    @DisplayName("")
    void findBookById() {
        //Arrange

        //Act

        //Assert

    }

    @Test
    @DisplayName("")
    void findAllBooks() {
        //Arrange

        //Act

        //Assert

    }

    @Test
    @DisplayName("")
    void deleteBook() {
        //Arrange

        //Act

        //Assert

    }
}