package com.example.familytree.model.dto;

import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data @NoArgsConstructor @Accessors(chain = true) @EqualsAndHashCode(callSuper = true)
public class PersonDto extends BasicPerson {
    ParentDto mom;
    ParentDto dad;
    Set<ChildDto> kids;

    public PersonDto(BasicPerson basicPerson) {
        super(basicPerson);
    }
}
