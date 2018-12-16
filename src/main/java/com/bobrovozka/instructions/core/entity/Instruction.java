package com.bobrovozka.instructions.core.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "instruction")
public class Instruction {

    @Id
    private String id;
    private long created;
    private long lastUpdated;
    private String name;
    private String description;
    private String body;
    private AccessType accessType;

    public Instruction(String name, String description, String body, AccessType accessType) {
        this.name = name;
        this.description = description;
        this.body = body;
        this.accessType = accessType;
    }
}
