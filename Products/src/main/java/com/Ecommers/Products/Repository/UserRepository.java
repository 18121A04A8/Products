package com.Ecommers.Products.Repository;


import com.Ecommers.Products.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    Optional<User> findById(Long aLong);


    Optional<User> findByName(String name);

}
