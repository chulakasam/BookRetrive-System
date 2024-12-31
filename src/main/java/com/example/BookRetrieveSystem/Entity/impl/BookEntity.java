package com.example.BookRetrieveSystem.Entity.impl;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Books")
public class BookEntity {
    @Id
    private String ISBN;
    private String title;
    private String author;
    @Column(columnDefinition = "LONGTEXT")
    private String image;
    private String price;
}
