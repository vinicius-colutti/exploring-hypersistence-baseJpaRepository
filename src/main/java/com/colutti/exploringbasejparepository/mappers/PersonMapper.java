package com.colutti.exploringbasejparepository.mappers;

import com.colutti.exploringbasejparepository.dtos.PersonDTO;
import com.colutti.exploringbasejparepository.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper( PersonMapper.class );

    PersonDTO personToPersonDto(Person person);
    Person personDtoToPerson(PersonDTO person);

}
