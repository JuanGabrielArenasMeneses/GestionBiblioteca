package com.biblioteca.gestionBiblioteca.domain.usecase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.biblioteca.gestionBiblioteca.domain.model.gateway.IUserRepository;
import com.biblioteca.gestionBiblioteca.domain.model.user.User;
import com.biblioteca.gestionBiblioteca.domain.model.user.dto.UserDTO;

public class UserUseCase {
    private final IUserRepository iUserRepository;

    public UserUseCase(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }
    public UserDTO saveUser(UserDTO userDTO) {
        User user = userDTO.toDomain(userDTO);
        return UserDTO.fromDomain(this.iUserRepository.saveUser(user));
    }
    public UserDTO updateUser(UserDTO userDTO) {
        User user = userDTO.toDomain(userDTO);
        return UserDTO.fromDomain(iUserRepository.updateUser(user));
    }
    public UserDTO findUserById(Long code) {
        User user = this.iUserRepository.findUserById(code);
        if (user != null) {
            return UserDTO.fromDomain(user);
        }
        return null;
    }
    public ArrayList<UserDTO> findAllUsers() {
        List<User> user = this.iUserRepository.findAllUsers();
        return (ArrayList<UserDTO>) user
                .stream()
                .map(UserDTO::fromDomain)
                .collect(Collectors.toList());
    }
    public Boolean deleteUser(Long code) {
        return iUserRepository.deleteUser(code);
    }

}
