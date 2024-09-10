package com.bach.notes.dto;


import com.bach.notes.model.UserEntity;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoteDto {

    Long id;
    @NotEmpty(message = "Note title shouldn't be empty")
    String title;
    @NotEmpty(message = "Note content shouldn't be empty")
    String content;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    UserEntity user;

}
