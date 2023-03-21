package com.biblioteca.gestionBiblioteca.infrastructure.adapters;

import com.biblioteca.gestionBiblioteca.domain.model.book.Book;
import com.biblioteca.gestionBiblioteca.domain.model.book.Code;
import com.biblioteca.gestionBiblioteca.domain.model.book.Name;
import com.biblioteca.gestionBiblioteca.domain.model.book.State;
import com.biblioteca.gestionBiblioteca.infrastructure.adapters.jpa.IBookRepositoryAdapter;
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
        Book book = new Book(new Code(2L),new Name("La Odisea"),new State(false));
        //Act
        Book book1 = bookRepositoryAdapter.saveBook(book);
        //Assert
        assertEquals("La Odisea",book1.getName().getValue());
    }

    @Test
    @DisplayName("Prueba updateBook")
    void updateBook() {
        //Arrange
        Book book = new Book(new Code(3L),new Name("La Voragine"),new State(true));
        book = bookRepositoryAdapter.saveBook(book);
        Book newBook = new Book(new Code(3L),new Name("La Odisea"),new State(false));
        //Act
        Book res = bookRepositoryAdapter.updateBook(newBook);
        //Assert
        assertEquals("La Odisea",res.getName().getValue());
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
        Book book = new Book(new Code(2L),new Name("La Odisea"),new State(false));
        book = bookRepositoryAdapter.saveBook(book);
        //Act
        boolean res = bookRepositoryAdapter.deleteBook(2L);
        //Assert
        assertTrue(res);
    }
}