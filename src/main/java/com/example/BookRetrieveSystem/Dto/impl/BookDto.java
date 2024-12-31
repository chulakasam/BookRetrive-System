package com.example.BookRetrieveSystem.Dto.impl;


import com.example.BookRetrieveSystem.Dto.BookStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookDto implements BookStatus {
    private String ISBN;
    private String title;
    private String author;
    private String image;
    private String price;
}
