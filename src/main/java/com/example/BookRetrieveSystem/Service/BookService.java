package com.example.BookRetrieveSystem.Service;

import com.example.BookRetrieveSystem.Dto.BookStatus;
import com.example.BookRetrieveSystem.Dto.impl.BookDto;

import java.util.List;

public interface BookService {
    void saveBook(BookDto bookDto);

    BookStatus getBook(String ISBN);

    List<BookDto> getAllBooks();

    void deleteBook(String ISBN);

    void updateBook(String ISBN, BookDto bookDto);
}
