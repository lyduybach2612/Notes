package com.bach.notes.mapper;

import com.bach.notes.dto.UserDto;
import com.bach.notes.model.UserEntity;

public class UserMapper {

    public static UserEntity mapToUserEntity(UserDto userDto) {
        return UserEntity.builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
//                .notes(userDto.getNotes())
                .build();
    }

    public static UserDto mapToUserDto(UserEntity userEntity) {
        return UserDto.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .email(userEntity.getEmail())
//                .notes(userEntity.getNotes())
                .build();
    }

}
