package com.colutti.exploringbasejparepository.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonDTO {

    @JsonProperty("person_id")
    private Long id;

    @JsonProperty("person_name")
    private String name;

    @JsonProperty("person_email")
    private String email;

    public PersonDTO(){}

    public PersonDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
