package com.biblioteca.gestionBiblioteca.infrastructure.adapters;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import com.biblioteca.gestionBiblioteca.domain.model.gateway.ILoanRepository;
import com.biblioteca.gestionBiblioteca.domain.model.loan.Loan;
import com.biblioteca.gestionBiblioteca.infrastructure.adapters.jpa.ILoanRepositoryAdapter;
import com.biblioteca.gestionBiblioteca.infrastructure.adapters.jpa.entity.dbo.LoanDBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
public class LoanRepositoryAdapter implements ILoanRepository {
    private final ILoanRepositoryAdapter iLoanRepositoryAdapter;

    @Override
    @Transactional
    public Loan saveLoan(Loan loan) {
        LoanDBO loanSaved = iLoanRepositoryAdapter.save(LoanDBO.fromDomain(loan));
        return LoanDBO.toDomain(loanSaved);
    }

    @Override
    @Transactional
    public Loan updateLoan(Loan loan) {
        LoanDBO dbo = LoanDBO.fromDomain(loan);
        Optional<LoanDBO> elementFound = iLoanRepositoryAdapter.findById(dbo.getId());
        if (elementFound.isEmpty()) {
            throw new NullPointerException(" No existe el libro con el codigo "+dbo.getId());
        }else {
            LoanDBO loanSaved = iLoanRepositoryAdapter.save(dbo);
            return LoanDBO.toDomain(loanSaved);
        }
    }
    @Override
    @Transactional(readOnly = true)
    public Loan findLoanById(Long code) {
        Optional<LoanDBO> dbo = iLoanRepositoryAdapter.findById(code);
        if(dbo.isEmpty()) {
            throw new NullPointerException("No existe el libro con el codigo: "+ code);
        }else{
            return LoanDBO.toDomain(dbo.get());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Loan> findAllLoans() {
        return iLoanRepositoryAdapter.findAll().stream().map(LoanDBO::toDomain).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Boolean deleteLoan(Long code) {
        AtomicReference<Boolean> bool = new AtomicReference<>(false);
        Optional<LoanDBO> dbo = iLoanRepositoryAdapter.findById(code);
        dbo.ifPresent(value -> iLoanRepositoryAdapter.deleteById(code));
        bool.set(true);
        return bool.get();
    }
}
