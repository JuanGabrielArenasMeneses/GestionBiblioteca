package com.biblioteca.gestionBiblioteca.infrastructure.adapters.jpa.entity.dbo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.biblioteca.gestionBiblioteca.domain.model.user.Code;
import com.biblioteca.gestionBiblioteca.domain.model.user.LoanedBooks;
import com.biblioteca.gestionBiblioteca.domain.model.user.Name;
import com.biblioteca.gestionBiblioteca.domain.model.user.PenaltyFee;
import com.biblioteca.gestionBiblioteca.domain.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USERS")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDBO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_CODE")
    private Long code;
    @Column(name = "USER_NAME")
    private Long name;
    @Column(name = "LOAN_BOOKS")
    private String loanedBooks;
    @Column(name = "PENALTY_FEE")
    private String penaltyFee;
    public static User toDomain(UserDBO userDBO){
        return new User(
                new Code(userDBO.getCode()),
                new Name(userDBO.getName()),
                new LoanedBooks(userDBO.getLoanedBooks()),
                new PenaltyFee(userDBO.getPenaltyFee())
        );
    }
    public static UserDBO fromDomain(User user){
        return new UserDBO(
                user.getCode().getValue(),
                user.getName().getValue(),
                user.getLoanedBooks().getValue(),
                user.getPenaltyFee().getValue()
        );
    }
}
