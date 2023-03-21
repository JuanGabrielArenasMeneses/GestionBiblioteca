package com.biblioteca.gestionBiblioteca.domain.model.book.dto;
import com.biblioteca.gestionBiblioteca.domain.model.book.Book;
import com.biblioteca.gestionBiblioteca.domain.model.book.Code;
import com.biblioteca.gestionBiblioteca.domain.model.book.Name;
import com.biblioteca.gestionBiblioteca.domain.model.book.State;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class BookDTO {
    private Long code;
    @NotNull
    @NotEmpty(message = "Escriba nombre del libro")
    @Pattern(regexp = "[\\p{L}\\s]+", message = "Ingrese nombre de libro con caracteres válidos")
    private String name;
    private Boolean state;

    public BookDTO(Long code, String name, Boolean state) {
        this.code = code;
        this.name = name;
        this.state = state;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
    public static Book toDomain(BookDTO bookDTO){
        return new Book(
                new Code(bookDTO.getCode()),
                new Name(bookDTO.getName()),
                new State(bookDTO.getState())
        );
    }
    public static BookDTO fromDomain(Book book){
        return new BookDTO(
                book.getCode().getValue(),
                book.getName().getValue(),
                book.getState().getValue()
        );
    }
}
