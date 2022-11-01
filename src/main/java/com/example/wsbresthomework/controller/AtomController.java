package com.example.wsbresthomework.controller;

import com.example.wsbresthomework.model.Atom;
import com.example.wsbresthomework.model.AtomDTo;
import com.example.wsbresthomework.service.AtomService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("atoms")
@AllArgsConstructor

public class AtomController {
    public final AtomService atomService;

    @GetMapping
    List<Atom> getAll(){
        return atomService.getAll();
    }

    @GetMapping({"{id}"})
    ResponseEntity<Atom> get(@PathVariable Long id){
        return ResponseEntity.ok(atomService.get(id));
    }

    @PostMapping
    ResponseEntity<Atom> create(@RequestBody AtomDTo atomDTo){
        Atom atom= atomService.create(atomDTo);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(atom);
    }

    @PutMapping("{id}")
    ResponseEntity<Atom> update (@PathVariable Long id,@RequestBody AtomDTo atomDTo){
        return ResponseEntity.ok(atomService.update(id,atomDTo));
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> delete(@PathVariable Long id){
        atomService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
