package kz.kassen.Tour_App.models;

import jakarta.persistence.*;

@Entity
public class ContactModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    @Column(columnDefinition = "TEXT")
    private String message;

    public ContactModel(String name, String email, String message) {
        this.name = name;
        this.email = email;
        this.message = message;
    }

    public ContactModel() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
