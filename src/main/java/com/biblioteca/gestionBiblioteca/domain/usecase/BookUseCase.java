package com.biblioteca.gestionBiblioteca.domain.usecase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.biblioteca.gestionBiblioteca.domain.model.book.Book;
import com.biblioteca.gestionBiblioteca.domain.model.book.dto.BookDTO;
import com.biblioteca.gestionBiblioteca.domain.model.gateway.IBookRepository;

public class BookUseCase {
    private final IBookRepository iBookRepository;

    public BookUseCase(IBookRepository iBookRepository) {
        this.iBookRepository = iBookRepository;
    }
    public BookDTO saveBook(BookDTO bookDTO) {
        Book book = bookDTO.toDomain(bookDTO);
        return BookDTO.fromDomain(this.iBookRepository.saveBook(book));
    }
    public BookDTO updateBook(BookDTO bookDTO) {
        Book book = bookDTO.toDomain(bookDTO);
        return BookDTO.fromDomain(iBookRepository.updateBook(book));
    }
    public BookDTO findBookById(Long code) {
        Book book = this.iBookRepository.findBookById(code);
        if (book != null) {
            return BookDTO.fromDomain(book);
        }
        return null;
    }
    public ArrayList<BookDTO> findAllBooks() {
        List<Book> book = this.iBookRepository.findAllBooks();
        return (ArrayList<BookDTO>) book
                .stream()
                .map(BookDTO::fromDomain)
                .collect(Collectors.toList());
    }
    public Boolean deleteBook(Long code) {
        return iBookRepository.deleteBook(code);
    }


}
