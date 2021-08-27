package com.ivoronline.springboot_db_query_jpql.repositories;

import com.ivoronline.springboot_db_query_jpql.entities.Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {

  //=======================================================================================
  // PARAMETERS
  //=======================================================================================
  //NO PARAMETERS
  @Query(value = "SELECT john FROM Person john WHERE john.name = 'John' AND john.age = 20")
  Person noParameters();

  //INDEXED PARAMETERS
  @Query(value = "SELECT person FROM Person person WHERE person.name = ?1 AND person.age = ?2")
  Person indexedParameters(String name, Integer age);

  //NAMED PARAMETERS
  @Query(value = "SELECT person FROM Person person WHERE person.name = :name AND person.age = :parameterAge")
  Person namedParameters(String name, @Param("parameterAge") Integer age);

  //=======================================================================================
  // SELECT
  //=======================================================================================
  //RETURN SINGLE ENTITY
  @Query(value = "SELECT john FROM Person john WHERE john.name = :name AND john.age = :age")
  Person selectPersonByNameAge(String name, Integer age);

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
  @Transactional
  @Query(value = "UPDATE Person person SET person.age = :newAge WHERE person.name = :name")
  Integer updatePersonsByName(String name, Integer newAge);

  //=======================================================================================
  // DELETE
  //=======================================================================================
  @Modifying
  @Transactional
  @Query(value = "DELETE FROM Person person WHERE person.name = :name")
  Integer deletePersonsByName(String name);

  //=======================================================================================
  // INSERT (NOT SUPPORTED BY JPA)
  //=======================================================================================

}
