package com.example.BookRetrieveSystem.Entity.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookEntity {
    private String ISBN;
    private String title;
    private String author;
    private String image;
    private String price;
}
