package com.bach.notes.service.impl;

import com.bach.notes.dto.ChangePasswordDto;
import com.bach.notes.dto.UserDto;
import com.bach.notes.mapper.UserMapper;
import com.bach.notes.model.UserEntity;
import com.bach.notes.repository.UserRepository;
import com.bach.notes.securityConfig.SecurityUtil;
import com.bach.notes.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Override
    public void save(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        UserEntity user = UserMapper.mapToUserEntity(userDto);
        userRepository.save(user);
    }

    @Override
    public UserEntity findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity findUserByUsername(String username) {
        return userRepository.findByUsername(username);    }

    @Override
    public void changePassword(ChangePasswordDto changePasswordDto) {
        String username = SecurityUtil.getSessionUser();
        UserEntity user = findUserByUsername(username);
        if(passwordEncoder.matches(changePasswordDto.getCurrentPassword(), user.getPassword())){
            user.setPassword(passwordEncoder.encode(changePasswordDto.getNewPassword()));
            userRepository.save(user);
        }
        else {
            throw new RuntimeException("Incorrect Password");
        }
    }


}
