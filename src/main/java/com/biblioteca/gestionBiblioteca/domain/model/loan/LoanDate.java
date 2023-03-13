package com.biblioteca.gestionBiblioteca.domain.model.loan;

import java.time.LocalDate;

public class LoanDate {
    private final LocalDate value;

    public LoanDate(LocalDate value) {
        this.value = value;
    }

    public LocalDate getValue() {
        return value;
    }
}
