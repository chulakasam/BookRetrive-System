package com.example.BookRetrieveSystem.Service;


import com.example.BookRetrieveSystem.Dto.impl.PasswordDto;
import com.example.BookRetrieveSystem.Secure.Response.JWTAuthResponse;
import com.example.BookRetrieveSystem.Secure.Security.SignIn;
import com.example.BookRetrieveSystem.Secure.Security.SignUp;

public interface AuthenticationService {
    JWTAuthResponse signUp(SignUp signUp);
    JWTAuthResponse signIn(SignIn signIn);
    JWTAuthResponse refreshToken(String refreshToken);
    void changePassword(PasswordDto passwordDto);
}
