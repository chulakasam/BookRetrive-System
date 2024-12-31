package com.example.BookRetrieveSystem.Service;

import com.example.BookRetrieveSystem.Dto.impl.UserWithKey;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailsService();
    boolean sendCodeToChangePassword(UserWithKey userWithKey);
}
