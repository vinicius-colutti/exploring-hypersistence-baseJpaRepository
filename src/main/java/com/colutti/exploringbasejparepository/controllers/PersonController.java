package com.colutti.exploringbasejparepository.controllers;

import com.colutti.exploringbasejparepository.dtos.PersonDTO;
import com.colutti.exploringbasejparepository.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    private IPersonService personService;

    public PersonController(@Autowired IPersonService personService){
        this.personService = personService;
    }

    @PostMapping
    public PersonDTO create(@RequestBody PersonDTO personDTO) {
        return personService.create(personDTO);
    }

    @PutMapping("/{id}")
    public PersonDTO update(@RequestBody PersonDTO personDTO, @PathVariable("id") Long id) {
        personDTO.setId(id);
        return personService.update(personDTO);
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable("id") Long id) {
        return personService.findById(id);
    }

    @GetMapping
    public Page<PersonDTO> findAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                   @RequestParam(defaultValue = "10") Integer pageSize,
                                   @RequestParam(defaultValue = "id") String sortBy){
        return personService.findAll(pageNo,pageSize,sortBy);
    }
}
