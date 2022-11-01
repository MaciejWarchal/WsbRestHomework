package com.example.wsbresthomework.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Atom {

    private Long id;
    private int atomicNumber;
    private String name;
    private String symbol;
    private double atomicWeight;
    private StateOfMatter stateOfMatter;

    public Atom(Long id,AtomDTo atomDTo){
        this.id=id;
        this.atomicNumber=atomDTo.getAtomicNumber();
        this.name=atomDTo.getName();
        this.symbol=atomDTo.getSymbol();
        this.atomicWeight=atomDTo.getAtomicWeight();
        this.stateOfMatter=atomDTo.getStateOfMatter();
    }

}
