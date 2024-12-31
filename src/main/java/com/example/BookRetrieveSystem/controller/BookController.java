package com.example.BookRetrieveSystem.controller;


import com.example.BookRetrieveSystem.Dto.BookStatus;
import com.example.BookRetrieveSystem.Dto.impl.BookDto;
import com.example.BookRetrieveSystem.Exception.BookNotFoundException;
import com.example.BookRetrieveSystem.Exception.DataPersistException;
import com.example.BookRetrieveSystem.Service.BookService;
import com.example.BookRetrieveSystem.Util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
@RequestMapping("api/v1/book")
@CrossOrigin(origins = "http://localhost:63342")
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
        String base64BookImage = "";
        try{
            byte [] bytesBookImage = image.getBytes();
            base64BookImage = AppUtil.BookImageOneToBase64(bytesBookImage);

            BookDto saveBookDto = new BookDto();
            saveBookDto.setISBN(ISBN);
            saveBookDto.setTitle(title);
            saveBookDto.setAuthor(author);
            saveBookDto.setImage(base64BookImage);
            saveBookDto.setPrice(price);


            bookService.saveBook(saveBookDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value = "/{ISBN}",produces = MediaType.APPLICATION_JSON_VALUE)
    public BookStatus getSelectedBook(@PathVariable ("ISBN") String ISBN){
        return bookService.getBook(ISBN);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookDto> getAllBooks(){
        return bookService.getAllBooks();
    }

    @DeleteMapping(value = "/{ISBN}")
    public ResponseEntity<Void> deleteBook(@PathVariable("ISBN") String ISBN){
        try {
            bookService.deleteBook(ISBN);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (BookNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{ISBN}")
    public ResponseEntity<Void> updateBook(@PathVariable("ISBN") String ISBN, @RequestBody BookDto bookDto) {
        try {
            bookService.updateBook(ISBN, bookDto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (BookNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
