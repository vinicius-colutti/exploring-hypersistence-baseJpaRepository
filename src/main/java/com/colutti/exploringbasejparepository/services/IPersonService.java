package com.colutti.exploringbasejparepository.services;

import com.colutti.exploringbasejparepository.dtos.PersonDTO;
import org.springframework.data.domain.Page;

public interface IPersonService {

    PersonDTO findById(Long id);
    PersonDTO create(PersonDTO person);
    PersonDTO update(PersonDTO person);
    Page<PersonDTO> findAll(Integer pageNo, Integer pageSize, String sortBy);

}
