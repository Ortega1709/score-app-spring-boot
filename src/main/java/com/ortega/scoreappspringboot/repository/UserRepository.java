package com.ortega.scoreappspringboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.ortega.scoreappspringboot.model.User;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);

}

