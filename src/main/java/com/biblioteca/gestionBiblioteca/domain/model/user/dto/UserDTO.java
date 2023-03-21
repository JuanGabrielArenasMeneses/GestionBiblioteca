package com.biblioteca.gestionBiblioteca.domain.model.user.dto;

import com.biblioteca.gestionBiblioteca.domain.model.user.Code;
import com.biblioteca.gestionBiblioteca.domain.model.user.LoanedBooks;
import com.biblioteca.gestionBiblioteca.domain.model.user.Name;
import com.biblioteca.gestionBiblioteca.domain.model.user.PenaltyFee;
import com.biblioteca.gestionBiblioteca.domain.model.user.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class UserDTO {
    @NotNull(message = "Este campo no debe estar vacío")
    @NotEmpty(message = "Este campo no debe estar vacío")
    @Length(min = 7, max = 15, message = "La cédula debe tener mínimo 7 dígitos y máximo 15")
    @Pattern(regexp = "\\d+", message = "Ingrese solo números")
    private Long code;
    @NotNull(message = "Este campo no debe estar vacío")
    @NotEmpty(message = "Escriba su nombre por favor")
    @Length(min = 3, max = 50, message = "El nombre debe incluir mínimo 3 caracteres y máximo 50")
    @Pattern(regexp = "[\\p{L}\\s]+", message = "Ingrese nombre con caracteres válidos")
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
