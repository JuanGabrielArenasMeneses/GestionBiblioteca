package com.biblioteca.gestionBiblioteca.infrastructure.adapters.jpa;

import com.biblioteca.gestionBiblioteca.infrastructure.adapters.jpa.entity.dbo.BookDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepositoryAdapter extends JpaRepository<BookDBO, Long> {
}
