package com.bach.notes.service.Impl;


import com.bach.notes.repository.NoteRepository;
import com.bach.notes.service.NoteService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    NoteRepository noteRepository;

}
