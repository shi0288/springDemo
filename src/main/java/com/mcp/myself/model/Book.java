package com.mcp.myself.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by bjjg11 on 2014/8/5.
 */

@Entity
@Table
public class Book {

    private String id;
    private String name;
    private String description;


    @GenericGenerator(name = "generator", strategy = "uuid")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
