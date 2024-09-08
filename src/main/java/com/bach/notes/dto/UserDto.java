package com.bach.notes.dto;

import com.bach.notes.model.Note;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    Long id;
    String username;
    String password;
    String email;
//    List<Note> notes;

}
