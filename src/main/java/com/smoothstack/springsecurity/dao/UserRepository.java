package com.smoothstack.springsecurity.dao;

import com.smoothstack.springsecurity.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rob Maes
 * Mar 16 2021
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  Optional<User> findByUserName(String userName);
}
