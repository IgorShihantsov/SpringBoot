package com.shihantsov.repository;

import com.shihantsov.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

    void removeByName(String name);


}
