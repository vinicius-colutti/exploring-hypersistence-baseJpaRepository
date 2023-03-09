package com.colutti.exploringbasejparepository.controllers;

import com.colutti.exploringbasejparepository.repositories.PersonRepository;
import com.colutti.exploringbasejparepository.utils.PersonTestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PersonTest extends PersonTestUtils {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PersonRepository personRepository;

    @Test
    public void when_sendValidPersonDto_expect_saveWithSuccess() throws Exception {
        mockMvc.perform(post("/person")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(generatePersonDto())))
                .andExpect(status().isOk());
    }

    @Test
    public void when_sendValidId_should_returnObject() throws Exception{
        mockMvc.perform(get("/person/"+1l)
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    public void when_sendValidPersonDtoWithId_expect_updateWithSuccess() throws Exception{
        mockMvc.perform(put("/person/"+1l)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(generatePersonDto())))
                .andExpect(status().isOk());
    }

}
