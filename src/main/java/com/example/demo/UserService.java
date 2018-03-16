package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {
    @Autowired
    UserRespository userRespository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    public UserService(UserRespository userRespository){
        this.userRespository = userRespository;
    }
    public User findbyemail(String email){
        return userRespository.findByEmail(email);
    }
    public Long countByEmail(String email){
        return userRespository.countByEmail(email);
    }
    public User findByUsername(String username) {
        return userRespository.findByUsername(username);
    }
    public void saveUser(User user){
        user.setRoles(Arrays.asList(roleRepository.findByRole("ADMIN")));
        user.setEnabled(true);
        userRespository.save(user);
    }
}
