package com.biblioteca.gestionBiblioteca.infrastructure.adapters.jpa;

import com.biblioteca.gestionBiblioteca.infrastructure.adapters.jpa.entity.dbo.LoanDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILoanRepositoryAdapter extends JpaRepository<LoanDBO, Long> {
}
