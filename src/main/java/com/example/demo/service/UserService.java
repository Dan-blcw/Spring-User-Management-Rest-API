package com.example.demo.service;

import com.example.demo.model.entities.User;
import com.example.demo.model.dto.CreateUserDto;
import com.example.demo.model.dto.UpdateUserDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {
    public List<User> getListUser();
    public User findById(Long id);
    public User save(CreateUserDto req);
    public void updateUser(User user);
    public User updateUser(UpdateUserDto req, Long id);
    public void deleteUser(Long id);

}
