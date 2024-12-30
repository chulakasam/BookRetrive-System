package com.example.BookRetrieveSystem.controller;


import com.example.BookRetrieveSystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveField(
            @RequestParam("ISBN") String ISBN,
            @RequestParam("title")String title,
            @RequestParam("author") String author,
            @RequestPart("image") MultipartFile image,
            @RequestParam("price") String price
    ) {



    }


}
