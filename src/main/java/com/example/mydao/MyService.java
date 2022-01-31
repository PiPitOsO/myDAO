package com.example.mydao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    private final MyRepository repository;

    public MyService(MyRepository repository) {
        this.repository = repository;
    }

    public String getProductName(String name) throws EmptyResultDataAccessException {
        return repository.get(name);
    }
}