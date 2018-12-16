package com.bobrovozka.instructions.core.service;

import com.bobrovozka.instructions.core.entity.Instruction;

import java.util.List;
import java.util.Optional;

public interface InstructionService {

    void save(Instruction instruction);

    Optional<Instruction> findById(String id);

    Instruction findByName(String name);

    List<Instruction> findAll();

    void update(Instruction instruction);

    void deleteById(String id);
}
