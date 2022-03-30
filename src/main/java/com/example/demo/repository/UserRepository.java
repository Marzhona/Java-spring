package com.example.demo.repository;

import com.example.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // Jpa Methods
    // 1
    List<User> findByEmailEndsWith(String email);
    //2
    List<User> findTop2ByNameStartsWith(String name);
    //3
   List<User> findBySurnameContainingOrderByName(String surname);
    //7
    List<User> findByEmailNotContainingOrderByName(String email);

    //10
  //  List<User> findDistinctTop1ByName(String name);





    // Native Query
    //4
   @Query(value = "select * from users order by id  " , nativeQuery = true)
    List<User> findAllId();
    //5
    @Query(value = "select * from users order by id desc limit 2 " , nativeQuery = true)
    List<User> findAllId2();
    //6
    @Query(value = "select * from users order by name desc  " , nativeQuery = true)
    List<User> findAllIdName();
    //8
    @Query(value = "select * from users where name = surname  " , nativeQuery = true)
    List<User> findAllE();

    //9
    @Query(value = "select * from users where email like '%gmail.com' or email like '%narxoz.kz' or email like '%example.com' " , nativeQuery = true)
       List<User> findAllNew();
    //10
    @Query(value = "select distinct on (name) *from users " , nativeQuery = true)
    List<User> findAllDist();




    @Query(value = "select * from users where id > :qid", nativeQuery = true)
    List<User> findByGreaterId(Long qid);

}