package com.ivoronline.springboot_db_query_jpql.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;
  public String  name;
  public Integer age;

  //CONSTRUCTORS
  public Person() { }                               //Forced by @Entity
  public Person(String name, Integer age) {         //To simplify PersonLoader
    this.name = name;
    this.age  = age;
  }

}
