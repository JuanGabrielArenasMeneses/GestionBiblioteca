package com.biblioteca.gestionBiblioteca.infrastructure.adapters.jpa;

import com.biblioteca.gestionBiblioteca.infrastructure.adapters.jpa.entity.dbo.UserDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepositoryAdapter extends JpaRepository<UserDBO, Long> {
}
