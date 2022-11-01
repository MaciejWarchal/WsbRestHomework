package com.example.wsbresthomework.service;

import com.example.wsbresthomework.exceptions.ResourceNotFoundException;
import com.example.wsbresthomework.model.Atom;
import com.example.wsbresthomework.model.AtomDTo;
import com.example.wsbresthomework.repository.AtomsRepository;
import lombok.*;
import org.springframework.stereotype.*;
import java.util.*;

@Service
@AllArgsConstructor
public class AtomService {
    private final AtomsRepository atomsRepository;

    public List<Atom> getAll(){
        return atomsRepository.getAll();
    }

    public Atom get(Long id){
        return atomsRepository
                .get(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public Atom create(AtomDTo atomDTo){
        return atomsRepository.create(atomDTo);
    }

    public Atom update(Long id,AtomDTo atomDTo){
        Atom atom=get(id);
        return atomsRepository.update(atom,atomDTo);
    }

    public void delete(Long id){
        Atom atom=get(id);
        atomsRepository.delete(atom);
    }
}
