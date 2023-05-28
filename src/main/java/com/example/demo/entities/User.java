package com.example.demo.entities;

import jakarta.persistence.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.NaturalId;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    /** The email. */
    @NaturalId
    @Column(name = "EMAIL")
    private String email;

    /** The name. */
    @Column(name = "NAME")
    private String name;

    /** User documents. */
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy="user")
    private List<Document> documents = new ArrayList<>();

    public User() {}

    public User(String email, String name, List<Document> documents) {
        this.email = email;
        this.name = name;
        this.documents = documents;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get user documents
     */
    public List<Document> getDocuments() {
        return documents;
    }

    /**
     * Set documents.
     *
     * @param documents user documents
     */
    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nName: ").append(name);
        sb.append("\nEmail: ").append(email);
        if(Hibernate.isInitialized(documents)) {
            for (Document document : documents) {
                sb.append("\n\tDocument: ").append(document.getDocumentNumber());
            }
        }
        return sb.toString();
    }
}