package com.bach.notes.repository;

import com.bach.notes.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Long, UserEntity> {
}
