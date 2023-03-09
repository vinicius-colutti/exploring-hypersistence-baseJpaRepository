package com.colutti.exploringbasejparepository.services.impl;

import com.colutti.exploringbasejparepository.dtos.PersonDTO;
import com.colutti.exploringbasejparepository.entities.Person;
import com.colutti.exploringbasejparepository.mappers.PersonMapper;
import com.colutti.exploringbasejparepository.repositories.PersonRepository;
import com.colutti.exploringbasejparepository.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PersonServiceImpl implements IPersonService {

    private PersonRepository personRepository;

    public PersonServiceImpl(@Autowired PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public PersonDTO findById(Long id) {
        return PersonMapper.INSTANCE.personToPersonDto(
                this.personRepository.findById(id).orElse(null)
        );
    }

    @Override
    @Transactional
    public PersonDTO create(PersonDTO person) {
        return PersonMapper.INSTANCE.personToPersonDto(
                this.personRepository.persist(
                        PersonMapper.INSTANCE.personDtoToPerson(person)
                )
        );
    }

    @Override
    @Transactional
    public PersonDTO update(PersonDTO person) {
        return PersonMapper.INSTANCE.personToPersonDto(
                this.personRepository.update(
                        PersonMapper.INSTANCE.personDtoToPerson(person)
                )
        );
    }

    @Override
    public Page<PersonDTO> findAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Person> pagedPersonResult = this.personRepository.findAll(paging);
        if (!pagedPersonResult.hasContent()) {
            return Page.empty();
        }
        return pagedPersonResult.map(person
                -> PersonMapper.INSTANCE.personToPersonDto(person));
    }

}
