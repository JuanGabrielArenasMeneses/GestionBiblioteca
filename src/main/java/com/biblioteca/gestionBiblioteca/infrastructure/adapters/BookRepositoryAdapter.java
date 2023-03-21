package com.biblioteca.gestionBiblioteca.infrastructure.adapters;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import com.biblioteca.gestionBiblioteca.domain.model.book.Book;
import com.biblioteca.gestionBiblioteca.domain.model.gateway.IBookRepository;
import com.biblioteca.gestionBiblioteca.infrastructure.adapters.jpa.IBookRepositoryAdapter;
import com.biblioteca.gestionBiblioteca.infrastructure.adapters.jpa.entity.dbo.BookDBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
public class BookRepositoryAdapter implements IBookRepository {
    private final IBookRepositoryAdapter iBookRepositoryAdapter;

    @Override
    @Transactional
    public Book saveBook(Book book) {
        BookDBO bookSaved = iBookRepositoryAdapter.save(BookDBO.fromDomain(book));
        return BookDBO.toDomain(bookSaved);
    }
    @Override
    @Transactional
    public Book updateBook(Book book) {
        BookDBO dbo = BookDBO.fromDomain(book);
        Optional<BookDBO> elementFound = iBookRepositoryAdapter.findById(dbo.getCode());
        if (elementFound.isEmpty()) {
            throw new NullPointerException(" No existe el libro con el codigo "+book.getCode().getValue());
        }else {
            BookDBO bookSaved = iBookRepositoryAdapter.save(dbo);
            return BookDBO.toDomain(bookSaved);
        }
    }
    @Override
    @Transactional(readOnly = true)
    public Book findBookById(Long code) {
        Optional<BookDBO> dbo = iBookRepositoryAdapter.findById(code);
        if(dbo.isEmpty()) {
            throw new NullPointerException("No existe el libro con el codigo: "+ code);
        }else{
            return BookDBO.toDomain(dbo.get());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> findAllBooks() {
        return iBookRepositoryAdapter.findAll().stream().map(BookDBO::toDomain).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Boolean deleteBook(Long code) {
        AtomicReference<Boolean> bool = new AtomicReference<>(false);
        Optional<BookDBO> dbo = iBookRepositoryAdapter.findById(code);
        dbo.ifPresent(value -> iBookRepositoryAdapter.deleteById(code));
        bool.set(true);
        return bool.get();
    }
}
