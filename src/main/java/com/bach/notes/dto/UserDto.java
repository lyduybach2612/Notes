package com.bach.notes.dto;

import com.bach.notes.model.Note;
import lombok.Builder;
import lombok.Data;
import java.util.*;

@Data
@Builder
public class UserDto {

    Long id;
    String username;
    String password;
    String email;
    List<Note> notes;

}
