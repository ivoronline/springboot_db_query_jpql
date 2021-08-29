package com.ivoronline.springboot_db_query_jpql.controllers;

import com.ivoronline.springboot_db_query_jpql.entities.Person;
import com.ivoronline.springboot_db_query_jpql.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

  @Autowired PersonRepository personRepository;

  //================================================================
  // NO PARAMETERS
  //================================================================
  @RequestMapping("NoParameters")
  Person noParameters() {
    Person person = personRepository.noParameters();
    return person;
  }

  //================================================================
  // INDEXED PARAMETERS
  //================================================================
  @RequestMapping("IndexedParameters")
  Person indexedParameters() {
    Person person = personRepository.indexedParameters("John", 20);
    return person;
  }

  //================================================================
  // NAMED PARAMETERS
  //================================================================
  @RequestMapping("NamedParameters")
  Person namedParameters() {
    Person person = personRepository.namedParameters("John", 20);
    return person;
  }

  //================================================================
  // SELECT PERSON BY NAME AGE (Returns Single Entity)
  //================================================================
  @RequestMapping("SelectPersonByNameAge")
  Person selectPersonByNameAge() {
    Person john = personRepository.selectPersonByNameAge("John", 20);
    return john;
  }

  //================================================================
  // SELECT PERSONS BY NAME (Returns List)
  //================================================================
  @RequestMapping("SelectPersonsByName")
  List<Person> selectPersonsByName() {
    List<Person> persons = personRepository.selectPersonsByName("John");
    return persons;
  }

  //================================================================
  // SELECT PERSONS BY NAME SORTED
  //================================================================
  @RequestMapping("SelectPersonsByNameSorted")
  List<Person> selectPersonsByNameSorted() {
    List<Person> persons = personRepository.selectPersonsByNameSorted("John", Sort.by("age"));
    return persons;
  }

  //================================================================
  // UPDATE PERSON BY NAME
  //================================================================
  @RequestMapping("UpdatePersonsByName")
  String updatePersonsByName() {
    Integer recordsUpdated = personRepository.updatePersonsByName("John", 50); //New age
    return  recordsUpdated + " Records Updated";
  }

  //================================================================
  // DELETE PERSON BY NAME
  //================================================================
  @RequestMapping("DeletePersonsByName")
  String deletePersonsByName() {

    Integer recordsDeleted = personRepository.deletePersonsByName("John");
    return  recordsDeleted + " Records Deleted";
  }

}
