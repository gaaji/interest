package com.gaaji.interest.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.gaaji.interest.applicationservice.InterestDeleteService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class InterestDeleteController {

	private final InterestDeleteService interestDeleteService;


    @DeleteMapping("/interest")
    public ResponseEntity<Void> deleteInterest(@RequestHeader(HttpHeaders.AUTHORIZATION) String userId,
            @RequestBody String postId){
    	interestDeleteService.deleteInterest(userId, postId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
