package com.bach.notes.dto;

import com.bach.notes.model.Note;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
    @NotEmpty(message = "Username cannot be empty")
    String username;
    @Size(min = 6, message = "Password must be at least 6 characters")
    @NotEmpty(message = "Password cannot be empty")
    String password;
    @NotEmpty(message = "Email cannot be empty")
    String email;
    List<Note> notes;

}
