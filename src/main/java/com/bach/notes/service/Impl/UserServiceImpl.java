package com.bach.notes.service.Impl;

import com.bach.notes.dto.UserDto;
import com.bach.notes.mapper.UserMapper;
import com.bach.notes.model.UserEntity;
import com.bach.notes.repository.UserRepository;
import com.bach.notes.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    public void save(UserDto userDto) {
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
}
