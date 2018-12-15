package com.bobrovozka.instructions.core.repository;

import com.bobrovozka.instructions.core.entity.Instruction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructionRepository extends MongoRepository<Instruction, String> {

    Instruction findByName(String name);

    void deleteById(String id);

}
