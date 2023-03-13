package com.biblioteca.gestionBiblioteca.domain.model.loan;

public class BookCode {
    private final Long value;

    public BookCode(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }
}
