package com.ivoronline.springboot_db_query_jpql.repositories;

import com.ivoronline.springboot_db_query_jpql.entities.Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {

  //NO PARAMETERS
  @Query(value = "SELECT john FROM Person john WHERE john.name = 'John' AND john.age = 20")
  Person getJohn();

  //INDEXED PARAMETERS
  @Query(value = "SELECT person FROM Person person WHERE person.name = ?1 AND person.age = ?2")
  Person getPersonByNameAgeIndexed(String name, Integer age);

  //NAMED PARAMETERS
  @Query(value = "SELECT person FROM Person person WHERE person.name = :name AND person.age = :parameterAge")
  Person getPersonByNameAgeNamed(String name, @Param("parameterAge") Integer age);

  //RETURN LIST
  @Query(value = "SELECT person FROM Person person WHERE person.name = :name")
  List<Person> getPersonsByName(String name);

  //RETURN SORTED LIST
  @Query(value = "SELECT person FROM Person person WHERE person.name = :name")
  List<Person> getPersonsByNameSorted(String name, Sort sort);

}
