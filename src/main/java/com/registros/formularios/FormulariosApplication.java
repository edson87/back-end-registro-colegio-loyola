package com.registros.formularios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class FormulariosApplication implements CommandLineRunner {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(FormulariosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String password = "12345";
        String password2 = "edson123";
        for (int i = 0; i<4;i++){
            String passwordBCrypt = passwordEncoder.encode(password);
            System.out.println(passwordBCrypt);
        }
    }
}
