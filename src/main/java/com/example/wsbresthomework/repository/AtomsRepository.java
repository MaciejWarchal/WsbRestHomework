package com.example.wsbresthomework.repository;

import com.example.wsbresthomework.model.*;
import com.example.wsbresthomework.model.StateOfMatter;
import com.example.wsbresthomework.model.Atom;
import org.springframework.stereotype.*;

import java.awt.*;
import java.util.*;
import java.util.List;

@Repository
public class AtomsRepository {

    static Long currentID= 5L;
    private final List<Atom> atomsList= new LinkedList<>(Arrays.asList(
    new Atom(1L,1,"hydrogen","H",1.008, StateOfMatter.gas),
    new Atom(2L,8,"oxygen","O",15.999,StateOfMatter.gas),
    new Atom(3L,6,"carbon","C",12.011,StateOfMatter.solid),
    new Atom(4L,80,"mercury","Hg",200.59,StateOfMatter.liquid)));

    public List<Atom>getAll(){
        return atomsList;
    }

    public Optional<Atom> get(Long id){
        return atomsList.stream()
                .filter(atoms -> atoms.getId().equals(id))
                .findFirst();
    }

    public Atom create(AtomDTo atomDTo){
        Atom newAtom= new Atom(currentID,atomDTo);
        atomsList.add(newAtom);
        return newAtom;
    }

    public Atom update(Atom atom,AtomDTo atomDTo){
        atom.setAtomicNumber(atomDTo.getAtomicNumber());
        atom.setName(atomDTo.getName());
        atom.setSymbol(atomDTo.getSymbol());
        atom.setAtomicWeight(atomDTo.getAtomicWeight());
        atom.setStateOfMatter(atomDTo.getStateOfMatter());
        return atom;
    }

    public void delete(Atom atom){
        atomsList.remove(atom);
    }
}
