package com.example.BookRetrieveSystem.Dto.impl;

import com.example.BookRetrieveSystem.Dto.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto implements UserStatus {
    private String user_id;
    private String email;
    private String password;
    private String role;
}
