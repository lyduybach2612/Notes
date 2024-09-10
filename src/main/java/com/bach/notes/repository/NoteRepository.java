package com.bach.notes.repository;

import com.bach.notes.model.Note;
import com.bach.notes.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByTitleContainingAndUser(String title, UserEntity user);
    List<Note> findByUser(UserEntity userEntity);
}
