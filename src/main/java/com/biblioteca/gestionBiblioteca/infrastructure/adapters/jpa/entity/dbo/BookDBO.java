package com.biblioteca.gestionBiblioteca.infrastructure.adapters.jpa.entity.dbo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.biblioteca.gestionBiblioteca.domain.model.book.Book;
import com.biblioteca.gestionBiblioteca.domain.model.book.Code;
import com.biblioteca.gestionBiblioteca.domain.model.book.Name;
import com.biblioteca.gestionBiblioteca.domain.model.book.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="BOOKS")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDBO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_CODE")
    private Long code;
    @Column(name = "BOOK_NAME")
    private String name;
    @Column(name = "BOOK_STATUS")
    private Boolean state;
    public static Book toDomain(BookDBO bookDBO){
        return new Book(
                new Code(bookDBO.getCode()),
                new Name(bookDBO.getName()),
                new State(bookDBO.getState())
        );
    }
    public static BookDBO fromDomain(Book book){
        return new BookDBO(
                book.getCode().getValue(),
                book.getName().getValue(),
                book.getState().getValue()
        );
    }
}
