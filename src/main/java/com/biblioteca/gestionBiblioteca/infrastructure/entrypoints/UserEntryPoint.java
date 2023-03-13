package com.biblioteca.gestionBiblioteca.infrastructure.entrypoints;

import java.util.List;

import com.biblioteca.gestionBiblioteca.domain.model.user.dto.UserDTO;
import com.biblioteca.gestionBiblioteca.domain.usecase.UserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserEntryPoint {
    private final UserUseCase userUseCase;
    @GetMapping
    public ResponseEntity<?> get(){
        List<UserDTO> users = userUseCase.findAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity(users, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity(users, HttpStatus.OK);
        }
    }
    @GetMapping("/{code}")
    public ResponseEntity<?> getById(@PathVariable(name = "code") Long code){
        return new ResponseEntity(userUseCase.findUserById(code), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserDTO userDTO){
        return new ResponseEntity(userUseCase.saveUser(userDTO), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody UserDTO userDTO){
        return new ResponseEntity(userUseCase.updateUser(userDTO), HttpStatus.OK);
    }
    @DeleteMapping("/{code}")
    public ResponseEntity<?> delete(@PathVariable Long code){
        return new ResponseEntity(userUseCase.deleteUser(code), HttpStatus.OK);
    }
}
