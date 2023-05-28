package com.example.demo.entities;

import jakarta.persistence.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "DOCUMENTS")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @NaturalId
    @Column(name = "DOCUMENT_NUMBER")
    private String documentNumber;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "DOCUMENT_NAME")
    private String documentName;

    public Document() {}

    public Document(String documentNumber, String documentName) {
        this.documentNumber = documentNumber;
        this.documentName = documentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nDocumentName: ").append(documentName);
        sb.append("\nDocumentNumber: ").append(documentNumber);
        if(user != null && Hibernate.isInitialized(user)) {
            sb.append("\n\tUser: ").append(user.getName());
        }
        return sb.toString();
    }
}