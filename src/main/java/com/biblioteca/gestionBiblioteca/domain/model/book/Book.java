package com.biblioteca.gestionBiblioteca.domain.model.book;

import com.biblioteca.gestionBiblioteca.domain.model.book.Code;
import com.biblioteca.gestionBiblioteca.domain.model.book.Name;
import com.biblioteca.gestionBiblioteca.domain.model.book.State;
import lombok.Data;

public class Book {
    private final Code code;
    private final Name name;
    private final State state;

    public Book(Code code, Name name, State state) {
        this.code = code;
        this.name = name;
        this.state = state;
    }

    public Code getCode() {
        return code;
    }

    public Name getName() {
        return name;
    }

    public State getState() {
        return state;
    }
}
