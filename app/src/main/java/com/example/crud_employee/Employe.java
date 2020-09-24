package com.example.crud_employee;
import java.io.Serializable;

public class Employe implements Serializable {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;
    private  String prenom;


    public Employe() {
    }

    @Override
    public String toString() {
        return
                 name +" " +
                 prenom
                ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Employe(String name, String prenom) {
        this.name = name;
        this.prenom = prenom;
    }
}
