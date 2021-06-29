package com.example.familytree.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data @NoArgsConstructor @Accessors(chain = true)
public class BasicPerson {
    protected Integer id;
    protected String name;
    protected Character gender;
    protected Boolean isAlive;

    public BasicPerson(BasicPerson basicPerson) {
        this.id = basicPerson.id;
        this.name = basicPerson.name;
        this.gender = basicPerson.gender;
        this.isAlive = basicPerson.isAlive;
    }
}
