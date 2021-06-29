package com.example.familytree.service;

import com.example.familytree.model.Person;
import com.example.familytree.model.dto.PersonDto;
import com.example.familytree.model.mapping.PersonMapper;
import com.example.familytree.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository repository;
    private final PersonMapper mapper;

    public PersonDto addPerson(PersonDto dto) {
        Person entity = mapper.map(dto);
        Person saved = repository.save(entity);
        return mapper.map(saved);
    }

    public PersonDto get(Integer personId) {
        Person entity = repository.getById(personId);
        return mapper.map(entity);
    }
}
