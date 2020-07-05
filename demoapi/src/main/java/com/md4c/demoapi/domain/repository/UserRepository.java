package com.md4c.demoapi.domain.repository;

import com.md4c.demoapi.domain.entity.UserI;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserI, Long> {
    Optional<UserI> findByUserName(String username);
}
