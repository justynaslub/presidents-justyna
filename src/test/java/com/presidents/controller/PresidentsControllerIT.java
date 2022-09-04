package com.presidents.controller;

import com.presidents.model.dto.PresidentDto;
import com.presidents.util.TestUtils;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.Timestamp;
import java.time.Instant;

import static com.presidents.util.TestUtils.toJson;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class PresidentsControllerIT {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenPostRequestForPresidentSave_thenCorrectResponse() throws Exception {
       //given
        var president = PresidentDto.builder().name("TestPresident").surname("TestPresident")
                .termFrom(Timestamp.from(Instant.ofEpochMilli(15000000)))
                .termTo(Timestamp.from(Instant.ofEpochMilli(16000000)))
                .politicalParty("TestParty").build();
        //when && then
        mockMvc.perform(post("/presidents/save").content(toJson(president))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", Matchers.equalTo("TestPresident")));
    }

    @Test
    public void whenPostPresidentAndIncorrectName_thenIncorrectResponse() throws Exception {
        //given
        var president = PresidentDto.builder().name(null).build();
        //when && then
        mockMvc.perform(post("/presidents/save").content(toJson(president))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", Matchers.containsInAnyOrder("Name is required")));
    }
}
