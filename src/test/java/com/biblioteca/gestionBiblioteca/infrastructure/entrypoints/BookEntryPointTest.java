package com.biblioteca.gestionBiblioteca.infrastructure.entrypoints;

import com.biblioteca.gestionBiblioteca.domain.model.book.Book;
import com.biblioteca.gestionBiblioteca.domain.model.book.Code;
import com.biblioteca.gestionBiblioteca.domain.model.book.Name;
import com.biblioteca.gestionBiblioteca.domain.model.book.State;
import com.biblioteca.gestionBiblioteca.domain.model.book.dto.BookDTO;
import com.biblioteca.gestionBiblioteca.domain.usecase.BookUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        BookDTO bookDTO = new BookDTO(2L,"La Odisea",false);
        when(bookUseCase.saveBook(any(BookDTO.class))).thenThrow(new IllegalArgumentException("Solo ingresar letras"));
        ObjectMapper mapper = new ObjectMapper();
        //Act //Assert
        mockMvc.perform(post("/book")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(bookDTO))
                                .andDo);

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