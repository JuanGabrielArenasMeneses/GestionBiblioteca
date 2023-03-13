package com.biblioteca.gestionBiblioteca.infrastructure.entrypoints;

import java.util.List;

import com.biblioteca.gestionBiblioteca.domain.model.book.dto.BookDTO;
import com.biblioteca.gestionBiblioteca.domain.usecase.BookUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BookEntryPoint {
    private final BookUseCase bookUseCase;
    @GetMapping
    public ResponseEntity<?> get(){
        List<BookDTO> books = bookUseCase.findAllBooks();
        if(books.isEmpty()){
            return new ResponseEntity(books, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity(books, HttpStatus.OK);
        }
    }
    @GetMapping("/{code}")
    public ResponseEntity<?> getById(@PathVariable(name = "code") Long code){
        return new ResponseEntity(bookUseCase.findBookById(code), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody BookDTO bookDTO){
        return new ResponseEntity(bookUseCase.saveBook(bookDTO), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody BookDTO bookDTO){
        return new ResponseEntity(bookUseCase.updateBook(bookDTO), HttpStatus.OK);
    }
    @DeleteMapping("/{code}")
    public ResponseEntity<?> delete(@PathVariable Long code){
        return new ResponseEntity(bookUseCase.deleteBook(code), HttpStatus.OK);
    }
}
