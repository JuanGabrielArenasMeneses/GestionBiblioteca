package com.biblioteca.gestionBiblioteca.domain.usecase;

import java.util.ArrayList;
import java.util.List;

import com.biblioteca.gestionBiblioteca.domain.model.book.Book;
import com.biblioteca.gestionBiblioteca.domain.model.book.dto.BookDTO;
import com.biblioteca.gestionBiblioteca.domain.model.gateway.IBookRepository;
import com.biblioteca.gestionBiblioteca.infrastructure.adapters.jpa.IBookRepositoryAdapter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class BookUseCaseTest {
    @InjectMocks
    private BookUseCase bookUseCase;
    @Mock
    private IBookRepository iSubjectRepository;
    @Autowired
    private IBookRepository iBookRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Prueba save book")
    void saveBook() throws Exception {
        //Arrange
        BookDTO bookDTO = new BookDTO(2L,"La Voragine", false);
        Book book = BookDTO.toDomain(bookDTO);
        when(iBookRepository.saveBook((any(Book.class)))).thenReturn(book);
        //Act
        //Assert
        BookDTO bookDTO1 = bookUseCase.saveBook(bookDTO);
        assertNotNull(bookDTO1);
        assertEquals(bookDTO1.getName(),"La Voragine");
    }

    @Test
    @DisplayName("")
    void updateBook() throws Exception {
        //Arrange

        //Act

        //Assert

    }

    @Test
    @DisplayName("Prueba findBookById")
    void findBookById() throws Exception {
        //Arrange
        BookDTO bookDTO = new BookDTO(3L,"La Odisea", false);
        Book book = BookDTO.toDomain(bookDTO);
        when(iBookRepository.findBookById(3L)).thenReturn(book);
        //Act//Assert
        BookDTO bookDTO1 = bookUseCase.findBookById(3L);
        assertNotNull(bookDTO1);
        assertEquals(bookDTO1.getName(),"La Odisea");
    }

    @Test
    @DisplayName("Prueba findAllBooks")
    void findAllBooks() throws Exception {
        //Arrange
        List<Book> list = new ArrayList<>();
        when(iBookRepository.findAllBooks()).thenReturn(list);
        //Act //Assert
        List<BookDTO> response = bookUseCase.findAllBooks();
        assertEquals(response, new ArrayList<>());
    }

    @Test
    @DisplayName("Prueba delete Book")
    void deleteBook() throws Exception {
        //Arrange
        when(iBookRepository.deleteBook(2L)).thenReturn(true);
        //Act//Assert
        boolean response = bookUseCase.deleteBook(2L);
        assertTrue(response);
    }
}