package com.example.BookRetrieveSystem.Dao;

import com.example.BookRetrieveSystem.Entity.impl.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<BookEntity,String> {
}
