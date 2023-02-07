package com.gaaji.interest.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.gaaji.interest.applicationservice.InterestExistRetrieveService;
import org.apache.http.HttpHeaders;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = InterestExistRetrieveController.class)
class InterestExistRetrieveControllerTest {
    
    @Autowired
    MockMvc mockMvc;
    
    @MockBean
    InterestExistRetrieveService interestExistRetrieveService;
    
    @InjectMocks
    InterestExistRetrieveController interestExistRetrieveController;
    
    @Test
    void 관심_조회_TRUE () throws Exception{
        //given
        given(interestExistRetrieveService.isExistInterest(anyString(), anyString(), any()))
                .willReturn(true);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/interest/post/asd/user/asdf?type=USEDITEM")
                .header(HttpHeaders.AUTHORIZATION,"Bearer tokens"))
                //then
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("true"))
                .andDo(print());
    }

    @Test
    void 관심_조회_FALSE () throws Exception{
        //given
        given(interestExistRetrieveService.isExistInterest(anyString(), anyString(), any()))
                .willReturn(false);
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/interest/post/asd/user/asdf?type=USEDITEM")
                        .header(HttpHeaders.AUTHORIZATION,"Bearer tokens"))
                //then
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("false"))
                .andDo(print());
    }

}