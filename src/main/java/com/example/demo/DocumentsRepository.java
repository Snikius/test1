package com.example.demo;

import com.example.demo.entities.Document;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DocumentsRepository extends CrudRepository<Document, Long>  {
    @Query("select document from Document document left join fetch document.user")
    List<Document> findAllWithUsers();
}
