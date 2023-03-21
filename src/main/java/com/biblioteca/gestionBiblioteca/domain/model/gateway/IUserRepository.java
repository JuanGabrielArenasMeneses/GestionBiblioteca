package com.biblioteca.gestionBiblioteca.domain.model.gateway;

import java.util.List;

import com.biblioteca.gestionBiblioteca.domain.model.user.User;
//@service
public interface IUserRepository {
    User saveUser(User user);

    User updateUser(User user);

    User findUserById(Long code);

    List<User> findAllUsers();

    Boolean deleteUser(Long code);
}
