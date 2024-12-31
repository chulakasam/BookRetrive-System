package com.example.BookRetrieveSystem.Util;

import com.example.BookRetrieveSystem.Dto.impl.BookDto;
import com.example.BookRetrieveSystem.Entity.impl.BookEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {

    @Autowired
    private ModelMapper modelMapper;
    public BookEntity toBookEntity(BookDto bookDto){
        return modelMapper.map(bookDto, BookEntity.class);
    }
    public BookDto toBookDTO(BookEntity bookEntity){
        return modelMapper.map(bookEntity, BookDto.class);
    }

    public List<BookDto> asBookDTOList(List<BookEntity> bookEntityList){return modelMapper.map(bookEntityList, new TypeToken<List<BookDto>>(){}.getType());
    }
    public List<BookEntity> toBookEntityList(List<BookDto> bookDTOList) {
        return modelMapper.map(bookDTOList,new TypeToken<List<BookEntity>>() {}.getType());
    }
}
