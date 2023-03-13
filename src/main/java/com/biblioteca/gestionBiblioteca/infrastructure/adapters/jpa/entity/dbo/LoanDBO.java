package com.biblioteca.gestionBiblioteca.infrastructure.adapters.jpa.entity.dbo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.biblioteca.gestionBiblioteca.domain.model.loan.BookCode;
import com.biblioteca.gestionBiblioteca.domain.model.loan.Loan;
import com.biblioteca.gestionBiblioteca.domain.model.loan.LoanDate;
import com.biblioteca.gestionBiblioteca.domain.model.loan.UserCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="LOANS")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoanDBO {
    @Id
    private Long id;
    private Long bookCode;
    private Long userCode;
    private LocalDate loanDate;
    public static Loan toDomain(LoanDBO loanDBO){
        return new Loan(
                new BookCode(loanDBO.getBookCode()),
                new UserCode(loanDBO.getUserCode()),
                new LoanDate(loanDBO.getLoanDate())
        );
    }
    public static LoanDBO fromDomain(Loan loan){
        return new LoanDBO(loan.getBookCode().getValue(),
                           loan.getUserCode().getValue(),
                           loan.getLoanDate().getValue()
                           );

    }
}
