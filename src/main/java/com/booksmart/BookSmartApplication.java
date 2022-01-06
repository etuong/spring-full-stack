package com.booksmart;

import com.booksmart.utility.Seeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BookSmartApplication extends SpringBootServletInitializer implements CommandLineRunner {

    @Autowired
    private Seeder seeder;

    public static void main(String[] args) {
        SpringApplication.run(BookSmartApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        seeder.seedUsers();
        seeder.seedBooks();
    }
}