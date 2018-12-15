package com.bobrovozka.instructions.core.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "instruction")
public class Instruction {

    @Id
    private String id;
    private String name;
    private String description;
    private String body;
    private AccessType accessType;

}
