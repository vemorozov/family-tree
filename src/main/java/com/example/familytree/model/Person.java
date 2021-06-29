package com.example.familytree.model;

import com.example.familytree.exception.EvolutionException;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain = true)
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Character gender;

    @Accessors(fluent = true)
    private Boolean isAlive;

    @ManyToOne
    @JoinColumn(name = "dad")
    private Person dad;

    @ManyToOne
    @JoinColumn(name = "mom")
    private Person mom;

    @ManyToMany
    @JoinTable(name = "parent_child_jt",
               joinColumns = @JoinColumn(name = "parent_id"),
               inverseJoinColumns = @JoinColumn(name = "child_id"))
    private Set<Person> kids;

    public void setKids(Set<Person> kids) {
        if (kids == null || kids.isEmpty()) {
            return;
        }

        if (this.kids == null) {
            this.kids = new HashSet<>();
        }

        for (Person kid : kids) {
            if (this.isDad()) {
                kid.setDad(this);
            } else if (this.isMom()) {
                kid.setMom(this);
            } else {
                throw new EvolutionException("Adopted kids don't count");
            }
            kids.add(kid);
        }
    }

    private boolean isDad() {
        return gender == 'M';
    }

    private boolean isMom() {
        return gender == 'F';
    }
}
