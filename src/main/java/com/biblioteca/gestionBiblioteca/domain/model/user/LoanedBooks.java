package com.biblioteca.gestionBiblioteca.domain.model.user;

public class LoanedBooks {
    private final String value;

    public LoanedBooks(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
