/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netbeans.spring.heroku;

/**
 *
 * @author UI600212
 */
import org.springframework.data.jpa.repository.JpaRepository;

    public interface ContactRepository extends JpaRepository<Contact, Long> {

}
