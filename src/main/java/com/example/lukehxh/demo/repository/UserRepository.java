package com.example.lukehxh.demo.repository;

import com.example.lukehxh.demo.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByNameIgnoreCaseContaining(String name);
    List<User> findByCpf(String cpf);
}
