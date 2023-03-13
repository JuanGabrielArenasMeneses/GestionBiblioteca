package com.biblioteca.gestionBiblioteca.domain.model.loan.dto;

import java.time.LocalDate;

import com.biblioteca.gestionBiblioteca.domain.model.loan.BookCode;
import com.biblioteca.gestionBiblioteca.domain.model.loan.Loan;
import com.biblioteca.gestionBiblioteca.domain.model.loan.LoanDate;
import com.biblioteca.gestionBiblioteca.domain.model.loan.UserCode;

public class LoanDTO {
    private Long bookCode;
    private Long userCode;
    private LocalDate loanDate;

    public LoanDTO(Long bookCode, Long userCode, LocalDate loanDate) {
        this.bookCode = bookCode;
        this.userCode = userCode;
        this.loanDate = loanDate;
    }

    public Long getBookCode() {
        return bookCode;
    }

    public void setBookCode(Long bookCode) {
        this.bookCode = bookCode;
    }

    public Long getUserCode() {
        return userCode;
    }

    public void setUserCode(Long userCode) {
        this.userCode = userCode;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }
    public static Loan toDomain(LoanDTO loanDTO){
        return new Loan(
                new BookCode(loanDTO.getBookCode()),
                new UserCode(loanDTO.getUserCode()),
                new LoanDate(loanDTO.getLoanDate())
        );
    }
    public static LoanDTO fromDomain(Loan loan){
        return new LoanDTO(
                loan.getBookCode().getValue(),
                loan.getUserCode().getValue(),
                loan.getLoanDate().getValue());
    }
}
