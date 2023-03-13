package com.biblioteca.gestionBiblioteca.infrastructure.entrypoints;

import com.biblioteca.gestionBiblioteca.domain.usecase.BookUseCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(BookEntryPoint.class)
class BookEntryPointTest {
    @MockBean
    private BookUseCase bookUseCase;
    @Autowired
    private MockMvc mockMvc;
    @BeforeEach
    void setUp() throws Exception{
    }

    @AfterEach
    void tearDown() throws Exception{
    }

    @Test
    @DisplayName("")
    void get() throws Exception{
        //Arrange

        //Act

        //Assert

    }

    @Test
    @DisplayName("")
    void getById() throws Exception{
        //Arrange

        //Act

        //Assert

    }

    @Test
    @DisplayName("")
    void create() throws Exception{
        //Arrange

        //Act

        //Assert

    }

    @Test
    @DisplayName("")
    void update() throws Exception{
        //Arrange

        //Act

        //Assert

    }

    @Test
    @DisplayName("")
    void delete() throws Exception{
        //Arrange

        //Act

        //Assert

    }
}