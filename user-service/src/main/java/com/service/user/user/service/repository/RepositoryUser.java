package com.service.user.user.service.repository;

import com.service.user.user.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryUser extends JpaRepository<User, Long> {

    User findUserById(Long id);

    User findByUserNameIgnoreCase(String userName);

    User findByEmail(String userName);

}
