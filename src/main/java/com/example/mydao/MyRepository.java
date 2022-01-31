package com.example.mydao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MyRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static String read() {
        try (InputStream is = new ClassPathResource("myScript.sql").getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String get(String name) {
        try {
            Order order = namedParameterJdbcTemplate.queryForObject(read(),
                    Map.of("name", name),
                    (rs, rowNum) -> new Order(rs.getString("name"), rs.getString("product_name"), rs.getInt("amount")));
            return order.toString();
        } catch (EmptyResultDataAccessException e) {
            System.out.println("didn't get anything");
            return null;
        }
    }
}
