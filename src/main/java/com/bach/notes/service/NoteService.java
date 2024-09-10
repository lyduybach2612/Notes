package com.bach.notes.service;

import com.bach.notes.dto.NoteDto;
import com.bach.notes.model.UserEntity;

import java.util.List;

public interface NoteService {
    List<NoteDto> findAllNote();

    void save(NoteDto note);

    NoteDto findNoteById(Long id);

    void updateNote(NoteDto note, Long noteId);

    void deleteNote(Long noteId);

    List<NoteDto> findAllNoteByTitle(String title);

    List<NoteDto> findAllNoteByUser(UserEntity user);
}
