package com.ivoronline.springboot_db_query_jpql.repositories;

import com.ivoronline.springboot_db_query_jpql.entities.Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {

  //=======================================================================================
  // SELECT
  //=======================================================================================

  //NO PARAMETERS
  @Query(value = "SELECT john FROM Person john WHERE john.name = 'John' AND john.age = 20")
  Person selectJohn();

  //INDEXED PARAMETERS
  @Query(value = "SELECT person FROM Person person WHERE person.name = ?1 AND person.age = ?2")
  Person selectPersonByNameAgeIndexed(String name, Integer age);

  //NAMED PARAMETERS
  @Query(value = "SELECT person FROM Person person WHERE person.name = :name AND person.age = :parameterAge")
  Person selectPersonByNameAgeNamed(String name, @Param("parameterAge") Integer age);

  //RETURN LIST
  @Query(value = "SELECT person FROM Person person WHERE person.name = :name")
  List<Person> selectPersonsByName(String name);

  //RETURN SORTED LIST
  @Query(value = "SELECT person FROM Person person WHERE person.name = :name")
  List<Person> selectPersonsByNameSorted(String name, Sort sort);

  //=======================================================================================
  // UPDATE
  //=======================================================================================
  @Modifying
  @Query(value = "UPDATE Person person SET person.age = :newAge WHERE person.name = :name")
  Integer updatePersonsByName(String name, Integer newAge);

  //=======================================================================================
  // DELETE
  //=======================================================================================
  @Modifying
  @Query(value = "DELETE FROM Person person WHERE person.name = :name")
  Integer deletePersonsByName(String name);

  //=======================================================================================
  // INSERT IS NOT SUPPORTED BY JPA
  //=======================================================================================

}
