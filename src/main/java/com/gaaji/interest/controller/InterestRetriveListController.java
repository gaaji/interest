package com.gaaji.interest.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.gaaji.interest.applicationservice.InterestDeleteService;
import com.gaaji.interest.applicationservice.InterestRetriveListService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class InterestRetriveListController {

	private final InterestRetriveListService interestRetriveListService;


    @GetMapping("/interest")
    public ResponseEntity<Void> retriveInterestList(@RequestHeader(HttpHeaders.AUTHORIZATION) String userId,
    		@RequestBody int pageNum){
    	interestRetriveListService.retriveInterestList(userId, pageNum);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
