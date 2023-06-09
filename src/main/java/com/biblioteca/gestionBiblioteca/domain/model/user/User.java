package com.biblioteca.gestionBiblioteca.domain.model.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class User {
    private final Code code;
    private final Name name;
    private final LoanedBooks loanedBooks;
    private final PenaltyFee penaltyFee;
    public User(Code code, Name name, LoanedBooks loanedBooks, PenaltyFee penaltyFee) {
        this.code = code;
        this.name = name;
        this.loanedBooks = loanedBooks;
        this.penaltyFee = penaltyFee;
    }

    public Code getCode() {
        return code;
    }

    public Name getName() {
        return name;
    }

    public LoanedBooks getLoanedBooks() {
        return loanedBooks;
    }

    public PenaltyFee getPenaltyFee() {
        return penaltyFee;
    }
}
