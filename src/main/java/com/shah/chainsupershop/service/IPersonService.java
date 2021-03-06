/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shah.chainsupershop.service;

import com.shah.chainsupershop.domain.Person;
import java.util.List;

/**
 *
 * @author Faculty
 */
public interface IPersonService {

    List<Person> getAllPersons();

    Person getPersonById(int pid);

    boolean addPerson(Person person);

    void updatePerson(Person person);

    void deletePerson(int pid);
}
