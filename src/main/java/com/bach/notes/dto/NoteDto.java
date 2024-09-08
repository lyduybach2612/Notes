package com.bach.notes.dto;


import com.bach.notes.model.UserEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NoteDto {

    Long id;
    String title;
    String content;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    UserEntity user;

}
