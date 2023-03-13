package com.biblioteca.gestionBiblioteca.domain.model.user.dto;

import com.biblioteca.gestionBiblioteca.domain.model.user.Code;
import com.biblioteca.gestionBiblioteca.domain.model.user.LoanedBooks;
import com.biblioteca.gestionBiblioteca.domain.model.user.Name;
import com.biblioteca.gestionBiblioteca.domain.model.user.PenaltyFee;
import com.biblioteca.gestionBiblioteca.domain.model.user.User;

public class UserDTO {
    private Long code;
    private Long name;
    private String loanedBooks;
    private String penaltyFee;

    public UserDTO(Long code, Long name, String loanedBooks, String penaltyFee) {
        this.code = code;
        this.name = name;
        this.loanedBooks = loanedBooks;
        this.penaltyFee = penaltyFee;
    }

    public UserDTO(Long code, Long name, String loanedBooks) {
        this.code = code;
        this.name = name;
        this.loanedBooks = loanedBooks;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getName() {
        return name;
    }

    public void setName(Long name) {
        this.name = name;
    }

    public String getLoanedBooks() {
        return loanedBooks;
    }

    public void setLoanedBooks(String loanedBooks) {
        this.loanedBooks = loanedBooks;
    }

    public String getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(String penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    public static User toDomain(UserDTO userDTO){
        return new User(
                new Code(userDTO.getCode()),
                new Name(userDTO.getName()),
                new LoanedBooks(userDTO.getLoanedBooks()),
                new PenaltyFee(userDTO.getPenaltyFee()));
    }
    public static UserDTO fromDomain(User user){
        return new UserDTO(
                user.getCode().getValue(),
                user.getName().getValue(),
                user.getLoanedBooks().getValue(),
                user.getPenaltyFee().getValue()
        );
    }
}
