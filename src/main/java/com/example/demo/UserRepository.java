package com.example.demo;

import java.util.List;

import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>  {
    List<User> findByEmail(String email);

    @Query("select user from User user left join fetch user.documents")
    List<User> findAllWithDocs();

    User findById(long id);
}
