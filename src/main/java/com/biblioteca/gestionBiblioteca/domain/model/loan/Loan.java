package com.biblioteca.gestionBiblioteca.domain.model.loan;

public class Loan {
    private final BookCode bookCode;
    private final UserCode userCode;
    private final LoanDate loanDate;

    public Loan(BookCode bookCode, UserCode userCode, LoanDate loanDate) {
        this.bookCode = bookCode;
        this.userCode = userCode;
        this.loanDate = loanDate;
    }

    public BookCode getBookCode() {
        return bookCode;
    }

    public UserCode getUserCode() {
        return userCode;
    }

    public LoanDate getLoanDate() {
        return loanDate;
    }
}
