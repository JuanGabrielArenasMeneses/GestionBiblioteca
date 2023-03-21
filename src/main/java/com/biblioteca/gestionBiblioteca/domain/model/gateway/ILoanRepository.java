package com.biblioteca.gestionBiblioteca.domain.model.gateway;

import java.util.List;

import com.biblioteca.gestionBiblioteca.domain.model.loan.Loan;
//@service
public interface ILoanRepository {
    Loan saveLoan(Loan loan);

    Loan updateLoan(Loan loan);

    Loan findLoanById(Long code);

    List<Loan> findAllLoans();

    Boolean deleteLoan(Long code);
}
