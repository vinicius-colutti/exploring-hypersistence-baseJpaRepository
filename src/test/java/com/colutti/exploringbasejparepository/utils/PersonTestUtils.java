package com.colutti.exploringbasejparepository.utils;

import com.colutti.exploringbasejparepository.dtos.PersonDTO;

public class PersonTestUtils {


    protected PersonDTO generatePersonDto(){
        return new PersonDTO(
                null,"user_name","user_email"
        );
    }

}
