package com.bach.notes.mapper;

import com.bach.notes.dto.NoteDto;
import com.bach.notes.model.Note;

public class NoteMapper {

    public static Note mapToNote(NoteDto noteDto){
        return Note.builder()
                .id(noteDto.getId())
                .title(noteDto.getTitle())
                .content(noteDto.getContent())
                .createdAt(noteDto.getCreatedAt())
                .updatedAt(noteDto.getUpdatedAt())
                .user(noteDto.getUser())
                .build();
    }

    public static NoteDto mapToNoteDto(Note note){
        return NoteDto.builder()
                .id(note.getId())
                .title(note.getTitle())
                .content(note.getContent())
                .createdAt(note.getCreatedAt())
                .updatedAt(note.getUpdatedAt())
                .user(note.getUser())
                .build();
    }

}
