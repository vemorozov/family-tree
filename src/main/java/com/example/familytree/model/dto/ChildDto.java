package com.example.familytree.model.dto;

import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data @NoArgsConstructor @Accessors(chain = true) @EqualsAndHashCode(callSuper = true)
public class ChildDto extends BasicPerson {
    Set<ChildDto> kids;

    public ChildDto(BasicPerson basicPerson) {
        super(basicPerson);
    }
}
