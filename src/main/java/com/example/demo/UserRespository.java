package com.example.demo;
import org.springframework.data.repository.CrudRepository;


public interface UserRespository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    Long countByEmail(String email);
    Long countByUsername(String username);

}
