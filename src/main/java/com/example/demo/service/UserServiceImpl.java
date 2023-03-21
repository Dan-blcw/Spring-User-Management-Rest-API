package com.example.demo.service;

import com.example.demo.exception.DuplicateRecordException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.entities.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.model.dto.CreateUserDto;
import com.example.demo.model.dto.UpdateUserAvatarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptEncoder;
    @Override
    public List<User> getListUser() {
        List<User> list = new ArrayList<>();
        userRepository
                .findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public User findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new NotFoundException("User not found!");
        }

        return optionalUser.get();
    }

    @Override
    public User save(CreateUserDto req) throws DuplicateRecordException {
        User newUser = new User();

        newUser.setName(req.getName());
        newUser.setEmail(req.getEmail());
        newUser.setPhone(req.getPhone());
        newUser.setPassword(bCryptEncoder.encode(req.getPassword()));
        newUser.setGender(req.getGender());
        newUser.setAvatar(null);

        return userRepository.save(newUser);
    }

    @Override
    public User updateUser(UpdateUserAvatarDto req, Long id) {
        User user = findById(id);
        if(req.getName() != null) {
            user.setName(req.getName());
        }
        if(req.getEmail() != null) {
            user.setEmail(req.getEmail());
        }
        if(req.getGender() != null) {
            user.setGender(req.getGender());
        }
        if(req.getGender() != null) {
            user.setGender(req.getGender());
        }
        if(req.getAvatar() != null) {
            user.setAvatar(req.getAvatar());
        }
        /*
            có thể tạo 1 update password ra bên ngoài cho tiện hơn nhưng lười =))
        */
        if(req.getPassword() != null) {
            user.setPassword(bCryptEncoder.encode(req.getPassword()));
        }
        return  userRepository.save(user);
    }
    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }


    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException
    {
        return (UserDetails) userRepository.findByEmail(email).orElseThrow(()
                        -> new UsernameNotFoundException(String.format("User of the email %s not found",email)));
    }
}
