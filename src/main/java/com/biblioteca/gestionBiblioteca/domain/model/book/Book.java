package com.biblioteca.gestionBiblioteca.domain.model.book;

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
