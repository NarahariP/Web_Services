package com.hari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hari.model.User;

@Repository
public interface UserRepositoty extends JpaRepository<User, Integer> {

}
