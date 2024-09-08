package com.bach.notes.service;

import com.bach.notes.dto.NoteDto;
import com.bach.notes.model.Note;

import java.util.List;

public interface NoteService {
    List<NoteDto> findAllNote();
}
