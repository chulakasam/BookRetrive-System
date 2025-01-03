package com.example.BookRetrieveSystem.Secure.Security;



import com.example.BookRetrieveSystem.Entity.Role;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SignUp {
    @NotNull(message = "email cannot be null")
    private String email;
    @NotNull
    private String password;
    @NotNull
    private Role role;
}
