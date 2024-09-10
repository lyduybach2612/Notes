package com.bach.notes.controller;

import com.bach.notes.dto.NoteDto;
import com.bach.notes.dto.UserDto;
import com.bach.notes.model.UserEntity;
import com.bach.notes.repository.SecurityUtil;
import com.bach.notes.service.NoteService;
import com.bach.notes.service.UserService;
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
    UserService userService;

    @GetMapping()
    public String noteListForm(Model model) {
        String username = SecurityUtil.getSessionUser();
        UserEntity user =  userService.findUserByUsername(username);
        List<NoteDto> notes = noteService.findAllNoteByUser(user);
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

    @GetMapping("/delete/{noteId}")
    public String deleteNote(@PathVariable Long noteId) {
        noteService.deleteNote(noteId);
        return "redirect:/notes";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "query") String query,Model model) {
        List<NoteDto> notes = noteService.findAllNoteByTitle(query);
        model.addAttribute("notes", notes);
        return "note-list";
    }

}
