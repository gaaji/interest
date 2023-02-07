package com.gaaji.interest.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaaji.interest.applicationservice.InterestCreateService;
import com.gaaji.interest.controller.dto.InterestCreateRequest;
import com.gaaji.interest.domain.PostType;
import com.gaaji.interest.exception.InputInvalidPostIdException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = InterestCreateController.class)
class InterestCreateControllerTest {

    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    InterestCreateController interestCreateController;

    @MockBean
    InterestCreateService interestCreateService;

    @Test
    void 정상_201을_반환한다 () throws Exception{
        //given
        InterestCreateRequest dto = new InterestCreateRequest("foo", PostType.USEDITEM);

        //when

        //then
        mockMvc.perform(post("/interest")
                .header(HttpHeaders.AUTHORIZATION,"AUTHORIZATION")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andDo(print());
    }
    @Test
    void 예외_400을_반환한다_post_id_invalid () throws Exception{
        //given
        InterestCreateRequest dto = new InterestCreateRequest("foo", PostType.USEDITEM);
        doThrow(new InputInvalidPostIdException())
                .when(interestCreateService)
                        .createInterest(anyString(), any(), anyString());

        //when
        mockMvc.perform(post("/interest")
                        .header(HttpHeaders.AUTHORIZATION,"AUTHORIZATION")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(dto)))
                //then
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.httpStatus").value("BAD_REQUEST"))
                .andExpect(jsonPath("$.errorCode").value("i-0005"))
                .andExpect(jsonPath("$.errorName").value("INPUT_INVALID_POST_ID"))
                .andExpect(jsonPath("$.errorMessage").value("사용할 수 없는 PostId를 전달했습니다."))
                .andExpect(jsonPath("$.path").value("/interest"))
                .andDo(print());
        
    
    }

}
