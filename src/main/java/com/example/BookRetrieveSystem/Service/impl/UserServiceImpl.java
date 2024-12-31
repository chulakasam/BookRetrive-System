package com.example.BookRetrieveSystem.Service.impl;

import com.example.BookRetrieveSystem.Dao.UserDao;
import com.example.BookRetrieveSystem.Dto.impl.UserWithKey;
import com.example.BookRetrieveSystem.Entity.impl.UserEntity;
import com.example.BookRetrieveSystem.Exception.UserNotFoundException;
import com.example.BookRetrieveSystem.Service.UserService;
import com.example.BookRetrieveSystem.Util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private Mapping mapping;

    @Override
    public UserDetailsService userDetailsService() {
        return username ->
                userDao.findByEmail(username).
                        orElseThrow(()->new UserNotFoundException("User Name Not Found"));
    }

    @Override
    public boolean sendCodeToChangePassword(UserWithKey userWithKey) {
        Optional<UserEntity> byEmail=userDao.findByEmail((userWithKey.getEmail()));
        if (byEmail.isPresent()){
            return true;
        }
        return false;
    }
}
