package com.bach.notes.service.Impl;


import com.bach.notes.dto.NoteDto;
import com.bach.notes.mapper.NoteMapper;
import com.bach.notes.model.Note;
import com.bach.notes.model.UserEntity;
import com.bach.notes.repository.NoteRepository;
import com.bach.notes.repository.SecurityUtil;
import com.bach.notes.repository.UserRepository;
import com.bach.notes.service.NoteService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    NoteRepository noteRepository;
    UserRepository userRepository;

    @Override
    public List<NoteDto> findAllNote() {
        List<Note> notes = noteRepository.findAll();
        return notes.stream().map(NoteMapper::mapToNoteDto).collect(Collectors.toList());
    }

    @Override
    public void save(NoteDto noteDto) {
        String username = SecurityUtil.getSessionUser();
        UserEntity user = userRepository.findByUsername(username);
        Note note = NoteMapper.mapToNote(noteDto);
        note.setUser(user);
        noteRepository.save(note);
    }

    @Override
    public NoteDto findNoteById(Long id) {
        Note note = noteRepository.findById(id).get();
        return NoteMapper.mapToNoteDto(note);
    }

    @Override
    public void updateNote(NoteDto noteDto, Long noteId) {
        Note note = NoteMapper.mapToNote(noteDto);
        note.setId(noteId);
        noteRepository.save(note);
    }

    @Override
    public void deleteNote(Long noteId) {
        noteRepository.deleteById(noteId);
    }

    @Override
    public List<NoteDto> findAllNoteByTitle(String title) {
        String username = SecurityUtil.getSessionUser();
        UserEntity user = userRepository.findByUsername(username);
        List<Note> notes = noteRepository.findByTitleContainingAndUser(title,user);
        return notes.stream().map(NoteMapper::mapToNoteDto).collect(Collectors.toList());
    }

    @Override
    public List<NoteDto> findAllNoteByUser(UserEntity user) {
        List<Note> notes = noteRepository.findByUser(user);
        return notes.stream().map(NoteMapper::mapToNoteDto).collect(Collectors.toList());
    }
}
