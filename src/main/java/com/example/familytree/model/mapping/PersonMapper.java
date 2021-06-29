package com.example.familytree.model.mapping;

import static java.util.Collections.emptySet;

import com.example.familytree.model.Person;
import com.example.familytree.model.dto.BasicPerson;
import com.example.familytree.model.dto.ChildDto;
import com.example.familytree.model.dto.ParentDto;
import com.example.familytree.model.dto.PersonDto;
import com.example.familytree.repository.PersonRepository;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PersonMapper {

    private final PersonRepository repository;

    public Person map(PersonDto dto) {
        Person entity;
        entity = getEntity(dto);
        return mapInternal(dto, entity);
    }

    public PersonDto map(Person entity) {
        return new PersonDto(basicPerson(entity))
                       .setDad(mapParent(entity.getDad()))
                       .setMom(mapParent(entity.getMom()))
                       .setKids(mapChildren(entity.getKids()));
    }

    private Set<ChildDto> mapChildren(Set<Person> entityList) {
        if (entityList == null || entityList.isEmpty()) {
            return emptySet();
        }
        Set<ChildDto> dtoList = new HashSet<>();
        for (Person entity : entityList) {
            dtoList.add(mapChild(entity));
        }
        return dtoList;
    }

    private ParentDto mapParent(Person entity) {
        if (entity == null) {
            return null;
        }

        return new ParentDto(basicPerson(entity))
                       .setDad(mapParent(entity.getDad()))
                       .setMom(mapParent(entity.getMom()));
    }

    private ChildDto mapChild(Person entity) {
        return new ChildDto(basicPerson(entity))
                       .setKids(mapChildren(entity.getKids()));
    }

    private BasicPerson basicPerson(Person entity) {
        return new BasicPerson()
                       .setId(entity.getId())
                       .setName(entity.getName())
                       .setGender(entity.getGender())
                       .setIsAlive(entity.isAlive());
    }

    private Person getEntity(PersonDto dto) {
        Person entity;
        if (dto.getId() == null) {
            entity = new Person();
        } else {
            entity = getPersonFromDB(dto);
        }
        return entity;
    }

    private Person getPersonFromDB(PersonDto dto) {
        Person entity;
        try {
            entity = repository.getById(dto.getId());
        } catch (EntityNotFoundException exception) {
            entity = new Person();
        }
        return entity;
    }

    private Person mapInternal(PersonDto dto, Person entity) {
        return entity.setId(dto.getId())
                     .setName(dto.getName())
                     .setGender(dto.getGender());
    }
}
