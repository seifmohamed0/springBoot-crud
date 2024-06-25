package com.global.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
