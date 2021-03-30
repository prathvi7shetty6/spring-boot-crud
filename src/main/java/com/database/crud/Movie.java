package com.database.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movies")

public class Movie {
    @Id
    private int id;
    @Column
    private String name;
    @Column
    private String actor;
    @Column
    private String actress;

    public Movie() {}

    public Movie(int id, String name, String actor, String actress) {
        this.id = id;
        this.name = name;
        this.actor = actor;
        this.actress = actress;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getActress() {
        return actress;
    }

    public void setActress(String actress) {
        this.actress = actress;
    }
}
