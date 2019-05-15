package com.jpasample.controllers;

import com.jpasample.dao.HiberDAO;
import com.jpasample.model.Cat;
import com.jpasample.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyRestController {
    @Autowired
    HiberDAO dao;


    @RequestMapping(value = "cat/{id}", method = RequestMethod.GET,
            produces = {"text/html"})
    String getCatS(@PathVariable("id") int id) {
        Cat cat = dao.findCat (id);
        return cat.toString();
    }

    @RequestMapping(value = "cat/{id}", method = RequestMethod.DELETE,
            produces = {"application/json"})
    String deleteCatS(@PathVariable("id") int id) {
        dao.deleteCat(id);
        return  "";
        //List<Cat> allCats = dao.getAllCats();
       // return cat.toString();
    }

    @RequestMapping(value = "/cat", method = RequestMethod.POST)
    String addCat(@RequestBody Cat c){
        dao.addCat(c);
        return "";
    }


    @RequestMapping(value = "cat/json/{id}", method = RequestMethod.GET,
            produces = {"application/json"})
    Cat getCat(@PathVariable("id") int id) {
        Cat cat = dao.findCat (id);
        return cat;
    }

    @RequestMapping(value = "person/{id}", method = RequestMethod.GET,
            produces = {"text/html"})
    String getPersonS(@PathVariable("id") int id) {
        Person person = dao.findPerson(id);
        return person.toString();
    }

    @RequestMapping(value = "person/json/{id}", method = RequestMethod.GET,
            produces = {"application/json"})
    Person getPerson(@PathVariable("id") int id) {
        Person person = dao.findPerson(id);
        return person;
    }

    @RequestMapping(value = "allcats", method = RequestMethod.GET,
            produces = {"application/json"})
    List<Cat> getCats() {
        return dao.getAllCats();
    }

    @RequestMapping(value = "allpersons", method = RequestMethod.GET,
            produces = {"application/json"})
    List<Person> getPersons() {
        return dao.getAllPersons();
    }


}
