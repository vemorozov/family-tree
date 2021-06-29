package com.example.familytree.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.example.familytree.model.dto.PersonDto;
import com.example.familytree.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController @RequestMapping("person")
public class PersonController {

    private final PersonService service;

    @GetMapping("{personId}")
    public PersonDto getPersonFamily(@PathVariable Integer personId) {
        return service.get(personId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public PersonDto post(@RequestBody PersonDto dto) {
        return service.addPerson(dto);
    }
}
