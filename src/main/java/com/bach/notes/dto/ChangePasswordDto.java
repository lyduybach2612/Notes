package com.bach.notes.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChangePasswordDto {
    @Size(min = 6, message = "Password must be at least 6 characters")
    String currentPassword;
    @Size(min = 6, message = "New password must be at least 6 characters")
    String newPassword;
}
