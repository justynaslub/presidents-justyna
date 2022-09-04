package com.presidents.service.president;

import com.presidents.model.entity.President;
import com.presidents.repository.PresidentsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
class PresidentServiceTest {

    @TestConfiguration
    static class PresidentServiceTestConfig {

        @Bean
        PresidentService presidentService(PresidentsRepository presidentsRepository){
            return new PresidentServiceImpl(presidentsRepository);
        }
    }

    @MockBean
    PresidentsRepository presidentsRepository;

    @Autowired
    PresidentService presidentService;

    @Test
    void whenSearchingForAllPresidents_shouldReturnAllPresidents() {
        //give
        List<President> presidents = Arrays.asList(
                President.builder().name("President1").surname("PresidentSurname").politicalParty("Party1").build(),
                President.builder().name("President1").surname("PresidentSurname2").politicalParty("Party2").build()
        );

        Mockito.when(presidentsRepository.findAll()).thenReturn(presidents);

        //when
        var presidentsDto = presidentService.getAllPresidents();

        //then
        Assertions.assertEquals(2,presidentsDto.size());
    }
}