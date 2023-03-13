package com.biblioteca.gestionBiblioteca.domain.model.gateway;

import java.util.List;

import com.biblioteca.gestionBiblioteca.domain.model.book.Book;

public interface IBookRepository {
    Book saveBook(Book book);

    Book updateBook(Book book);

    Book findBookById(Long code);

    List<Book> findAllBooks();

    Boolean deleteBook(Long code);
}
