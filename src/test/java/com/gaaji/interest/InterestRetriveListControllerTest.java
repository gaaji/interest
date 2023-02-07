package com.gaaji.interest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaaji.interest.applicationservice.InterestDeleteService;
import com.gaaji.interest.applicationservice.InterestRetriveListService;
import com.gaaji.interest.controller.InterestDeleteController;
import com.gaaji.interest.controller.InterestRetriveListController;

@WebMvcTest(controllers = InterestRetriveListController.class)
public class InterestRetriveListControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    InterestRetriveListService interestRetriveListService;

    @InjectMocks
    InterestRetriveListController interestRetriveListController;

    @Test
    void 관삼목록_조회() throws Exception {
        //given

        mockMvc.perform(MockMvcRequestBuilders.get("/interest")
                        .header(HttpHeaders.AUTHORIZATION, "authId")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsBytes(1)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
        //when

        //then

    }
}
