package com.biblioteca.gestionBiblioteca.infrastructure.entrypoints;

import java.util.List;

import com.biblioteca.gestionBiblioteca.domain.model.loan.dto.LoanDTO;
import com.biblioteca.gestionBiblioteca.domain.usecase.LoanUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan")
@AllArgsConstructor
public class LoanEntrypoint {
    private final LoanUseCase loanUseCase;
    @GetMapping
    public ResponseEntity<?> get(){
        List<LoanDTO> loans = loanUseCase.findAllLoans();
        if(loans.isEmpty()){
            return new ResponseEntity(loans, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity(loans, HttpStatus.OK);
        }
    }
    @GetMapping("/{code}")
    public ResponseEntity<?> getById(@PathVariable(name = "code") Long code){
        return new ResponseEntity(loanUseCase.findLoanById(code), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody LoanDTO loanDTO){
        return new ResponseEntity(loanUseCase.saveLoan(loanDTO), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody LoanDTO loanDTO){
        return new ResponseEntity(loanUseCase.updateLoan(loanDTO), HttpStatus.OK);
    }
    @DeleteMapping("/{code}")
    public ResponseEntity<?> delete(@PathVariable Long code){
        return new ResponseEntity(loanUseCase.deleteLoan(code), HttpStatus.OK);
    }
}
