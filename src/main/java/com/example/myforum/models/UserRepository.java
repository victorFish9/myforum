package com.example.myforum.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findBySize(int size);
    List<User> findByNameAndPassword(String name, String password);
}
