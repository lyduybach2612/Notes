package com.bach.notes.service.Impl;


import com.bach.notes.dto.NoteDto;
import com.bach.notes.mapper.NoteMapper;
import com.bach.notes.model.Note;
import com.bach.notes.repository.NoteRepository;
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

    @Override
    public List<NoteDto> findAllNote() {
        List<Note> notes = noteRepository.findAll();
        return notes.stream().map(NoteMapper::mapToNoteDto).collect(Collectors.toList());
    }
}
