package com.example.mydao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class CommandLineApp implements CommandLineRunner {

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

    @Override
    public void run(String... args) throws Exception {
        String name = "'Vova'";
        Order order = namedParameterJdbcTemplate.queryForObject(read(),
                Map.of("name", name),
                (rs, rowNum) -> new Order(rs.getString("name"), rs.getString("product"), rs.getInt("amount")));
        System.out.println(order);
    }
//    private static getProductName(String name) {
//
//
//    }

    public static class Order {
        private String name;
        private String product;
        private int amount;

        public Order(String name, String product, int amount) {
            this.name = name;
            this.product = product;
            this.amount = amount;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getProduct() {
            return product;
        }

        public void setProduct(String product) {
            this.product = product;
        }

        @Override
        public String toString() {
            return name + " заказал " + product + " в количестве: " + amount;
        }
    }
}