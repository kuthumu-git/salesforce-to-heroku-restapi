/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netbeans.spring.heroku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author UI600212
 */
@SpringBootApplication
public class ContactApplication {

    public static void main(String[] args) {
        System.out.println("1...");
        SpringApplication.run(ContactApplication.class, args);
        System.out.println("2...");
    }

}