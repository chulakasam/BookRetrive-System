package com.example.BookRetrieveSystem.Service.impl;

import com.example.BookRetrieveSystem.Dao.BookDao;
import com.example.BookRetrieveSystem.Dto.BookStatus;
import com.example.BookRetrieveSystem.Dto.impl.BookDto;
import com.example.BookRetrieveSystem.Entity.impl.BookEntity;
import com.example.BookRetrieveSystem.Exception.BookNotFoundException;
import com.example.BookRetrieveSystem.Service.BookService;
import com.example.BookRetrieveSystem.Util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private Mapping mapping;


    @Override
    public void saveBook(BookDto bookDto) {
        BookEntity bookEntity = bookDao.save(mapping.toBookEntity(bookDto));
        if(bookEntity==null){
            throw new BookNotFoundException("Book not found !!!!");
        }
    }

    @Override
    public BookStatus getBook(String ISBN) {
        if(bookDao.existsById(ISBN)){
            BookEntity selectedBook = bookDao.getReferenceById(ISBN);
            return mapping.toBookDTO(selectedBook);
        }else {
             throw new BookNotFoundException("Book not found !!!!");
        }
    }

    @Override
    public List<BookDto> getAllBooks() {
        return null;
    }

    @Override
    public void deleteBook(String ISBN) {

    }

    @Override
    public void updateBook(String ISBN, BookDto bookDto) {

    }
}
