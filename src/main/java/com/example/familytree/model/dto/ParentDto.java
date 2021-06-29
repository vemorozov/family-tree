package com.example.familytree.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data @NoArgsConstructor @Accessors(chain = true) @EqualsAndHashCode(callSuper = true)
public class ParentDto extends BasicPerson {
    ParentDto mom;
    ParentDto dad;

    public ParentDto(BasicPerson basicPerson) {
        super(basicPerson);
    }
}
