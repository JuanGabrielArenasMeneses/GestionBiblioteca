package com.biblioteca.gestionBiblioteca.infrastructure.adapters;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import com.biblioteca.gestionBiblioteca.domain.model.gateway.IUserRepository;
import com.biblioteca.gestionBiblioteca.domain.model.user.User;
import com.biblioteca.gestionBiblioteca.infrastructure.adapters.jpa.IUserRepositoryAdapter;
import com.biblioteca.gestionBiblioteca.infrastructure.adapters.jpa.entity.dbo.UserDBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserRepositoryAdapter implements IUserRepository {
    private final IUserRepositoryAdapter iUserRepositoryAdapter;

    @Override
    @Transactional
    public User saveUser(User user) {
        UserDBO userSaved = iUserRepositoryAdapter.save(UserDBO.fromDomain(user));
        return UserDBO.toDomain(userSaved);
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        UserDBO dbo = UserDBO.fromDomain(user);
        Optional<UserDBO> elementFound = iUserRepositoryAdapter.findById(dbo.getCode());
        if (elementFound.isEmpty()) {
            throw new NullPointerException(" No existe el libro con el codigo "+user.getCode().getValue());
        }else {
            UserDBO userSaved = iUserRepositoryAdapter.save(dbo);
            return UserDBO.toDomain(userSaved);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserById(Long code) {
        Optional<UserDBO> dbo = iUserRepositoryAdapter.findById(code);
        if(dbo.isEmpty()) {
            throw new NullPointerException("No existe el libro con el codigo: "+ code);
        }else{
            return UserDBO.toDomain(dbo.get());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAllUsers() {
        return iUserRepositoryAdapter.findAll().stream().map(UserDBO::toDomain).collect(Collectors.toList());
    }

    @Override@Transactional
    public Boolean deleteUser(Long code) {
        AtomicReference<Boolean> bool = new AtomicReference<>(false);
        Optional<UserDBO> dbo = iUserRepositoryAdapter.findById(code);
        dbo.ifPresent(value -> iUserRepositoryAdapter.deleteById(code));
        bool.set(true);
        return bool.get();
    }
}
