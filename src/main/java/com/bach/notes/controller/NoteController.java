package com.bach.notes.controller;

import com.bach.notes.dto.NoteDto;
import com.bach.notes.model.Note;
import com.bach.notes.service.NoteService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import  java.util.*;
@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/notes")
public class NoteController {

    NoteService noteService;

    @GetMapping("")
    public String noteListForm(Model model) {
        List<NoteDto> notes = noteService.findAllNote();
        model.addAttribute("notes", notes);
        return "note-list";
    }


}
