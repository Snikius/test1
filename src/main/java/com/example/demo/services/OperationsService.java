package com.example.demo.services;

import com.example.demo.DocumentsRepository;
import com.example.demo.UserRepository;
import com.example.demo.entities.Document;
import com.example.demo.entities.User;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OperationsService {

    private static final Logger log = LoggerFactory.getLogger(OperationsService.class);

    private final UserRepository userRepository;
    private final DocumentsRepository documentsRepository;
    private final EntityManager entityManager;

    @Autowired
    public OperationsService(
            UserRepository userRepository,
            DocumentsRepository documentsRepository,
            EntityManager entityManager
    ) {
        this.userRepository = userRepository;
        this.documentsRepository = documentsRepository;
        this.entityManager = entityManager;
    }

    @Transactional
    public void addUsers() {
        var documentList1 = List.of(new Document("doc1", "doc name 1"));
        var user1 = new User("person_b@mail.ru", "Bauer", documentList1);
        documentList1.forEach((d) -> d.setUser(user1));

        var documentList2 = List.of(
                new Document("doc2", "doc name 2"),
                new Document("doc3", "doc name 3"),
                new Document("doc4", "doc name 4")
        );
        var user2 = new User("person_j@mail.ru", "Jon", documentList2);
        documentList2.forEach((d) -> d.setUser(user2));

        var documentList3 = List.of(
                new Document("doc5", "doc name 5")
        );
        var user3 = new User("person_f@mail.ru", "Fredy", documentList3);
        documentList3.forEach((d) -> d.setUser(user3));

        var user4 = new User("person_h@mail.ru", "Hary", null);

        userRepository.saveAll(List.of(user1, user2, user3, user4));
    }

    public void listUsers() {
        log.info("--------------- LIST ----------------");
        for (User user : userRepository.findAllWithDocs()) {
            log.info(user.toString());
        }
        log.info("-------------- END LIST -------------");
    }

    public void listDocuments() {
        log.info("--------------- LIST ----------------");
        for (Document document : documentsRepository.findAllWithUsers()) {
            log.info(document.toString());
        }
        log.info("-------------- END LIST -------------");
    }

    public void deleteUsers() {
        userRepository.deleteAll();
    }
}
