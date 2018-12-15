package com.bobrovozka.instructions.core.service.impl;

import com.bobrovozka.instructions.core.entity.Instruction;
import com.bobrovozka.instructions.core.repository.InstructionRepository;
import com.bobrovozka.instructions.core.service.InstructionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class InstructionServiceImpl implements InstructionService {

    private InstructionRepository repository;

    public InstructionServiceImpl(InstructionRepository repository) {
        this.repository = repository;
    }


    @Override
    public void create(Instruction instruction) {
        repository.save(instruction);
        log.info("Instruction created & saved to repo: {}", instruction.toString());
    }

    @Override
    public Optional<Instruction> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Instruction findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Instruction> findAll() {
        return repository.findAll();
    }

    @Override
    public void update(Instruction instruction) {
        repository.save(instruction);
        log.info("Instruction updated in repo: {}", instruction.toString());
    }

    @Override
    public void deleteById(String id) {
        Instruction instruction = repository.findById(id).get();
        log.info("Instruction with \n ID: {} \n NAME: {} \n deleted", instruction.getId(), instruction.getName());
        repository.deleteById(id);
    }
}
