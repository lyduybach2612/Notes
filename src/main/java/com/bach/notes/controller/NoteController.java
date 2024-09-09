package com.bach.notes.controller;

import com.bach.notes.dto.NoteDto;
import com.bach.notes.model.Note;
import com.bach.notes.service.NoteService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import  java.util.*;
@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/notes")
public class NoteController {

    NoteService noteService;

    @GetMapping()
    public String noteListForm(Model model) {
        List<NoteDto> notes = noteService.findAllNote();
        model.addAttribute("notes", notes);
        return "note-list";
    }

    @GetMapping("/new")
    public String createNoteForm(Model model) {
        NoteDto note = new NoteDto();
        model.addAttribute("note", note);
        return "create-note";
    }

    @PostMapping("/new")
    public String createNote(@ModelAttribute("note") @Valid NoteDto note,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("note", note);
            return "create-note";
        }
        noteService.save(note);
        return "redirect:/notes";
    }

    @GetMapping("/edit/{noteId}")
    public String editNoteForm(@PathVariable Long noteId, Model model) {
        NoteDto note = noteService.findNoteById(noteId);
        model.addAttribute("note", note);
        return "edit-note";
    }

    @PostMapping("/edit/{noteId}")
    public String updateNote(@PathVariable Long noteId,
                             @ModelAttribute("note") @Valid NoteDto note,
                           BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("note", note);
            return "edit-note";
        }
        noteService.updateNote(note, noteId);
        return "redirect:/notes";
    }

}
