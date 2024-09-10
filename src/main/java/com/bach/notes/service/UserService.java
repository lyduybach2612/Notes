package com.bach.notes.service;

import com.bach.notes.dto.UserDto;
import com.bach.notes.model.UserEntity;

public interface UserService {
    void save(UserDto userDto);
    UserEntity findUserByEmail(String email);
    UserEntity findUserByUsername(String username);
}
