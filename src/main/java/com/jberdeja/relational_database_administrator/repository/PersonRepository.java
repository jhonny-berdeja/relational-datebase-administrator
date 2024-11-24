package com.jberdeja.relational_database_administrator.repository;

import com.jberdeja.relational_database_administrator.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

    List<Person> findByDni(Long dni);
}
