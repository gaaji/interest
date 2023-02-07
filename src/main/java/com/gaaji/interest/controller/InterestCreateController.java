package com.gaaji.interest.controller;

import com.gaaji.interest.applicationservice.InterestCreateService;
import com.gaaji.interest.controller.dto.InterestCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class InterestCreateController {

    private final InterestCreateService interestCreateService;

    @PostMapping("/interest")
    public ResponseEntity<Void> createInterest(@RequestHeader(HttpHeaders.AUTHORIZATION) String authId,@RequestBody InterestCreateRequest dto){

        interestCreateService.createInterest(dto.getPostId(), dto.getPostType(), authId);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

}
