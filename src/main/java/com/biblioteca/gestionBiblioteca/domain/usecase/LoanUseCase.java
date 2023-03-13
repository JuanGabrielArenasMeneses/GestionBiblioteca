package com.biblioteca.gestionBiblioteca.domain.usecase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.biblioteca.gestionBiblioteca.domain.model.gateway.ILoanRepository;
import com.biblioteca.gestionBiblioteca.domain.model.loan.Loan;
import com.biblioteca.gestionBiblioteca.domain.model.loan.dto.LoanDTO;

public class LoanUseCase {
    private final ILoanRepository iLoanRepository;

    public LoanUseCase(ILoanRepository iLoanRepository) {
        this.iLoanRepository = iLoanRepository;
    }
    public LoanDTO saveLoan(LoanDTO loanDTO) {
        Loan loan = loanDTO.toDomain(loanDTO);
        return LoanDTO.fromDomain(this.iLoanRepository.saveLoan(loan));
    }

    public LoanDTO updateLoan(LoanDTO loanDTO) {
        Loan loan = loanDTO.toDomain(loanDTO);
        return LoanDTO.fromDomain(iLoanRepository.updateLoan(loan));
    }

    public LoanDTO findLoanById(Long code) {
        Loan loan = this.iLoanRepository.findLoanById(code);
        if (loan != null) {
            return LoanDTO.fromDomain(loan);
        }
        return null;
    }

    public ArrayList<LoanDTO> findAllLoans() {
        List<Loan> loan = this.iLoanRepository.findAllLoans();
        return (ArrayList<LoanDTO>) loan
                .stream()
                .map(LoanDTO::fromDomain)
                .collect(Collectors.toList());
    }

    public Boolean deleteLoan(Long code) {
        return iLoanRepository.deleteLoan(code);
    }
}
