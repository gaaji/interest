package com.gaaji.interest.controller;


import com.gaaji.interest.applicationservice.InterestExistRetrieveService;
import com.gaaji.interest.domain.PostType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class InterestExistRetrieveController {

    private final InterestExistRetrieveService interestExistRetrieveService;

    @GetMapping("/interest/post/{postId}/user/{userId}")
    public ResponseEntity<Boolean> isExistInterest(@PathVariable("postId") String postId,
            @PathVariable("userId") String userId, @RequestParam(name = "type")PostType postType){

        boolean interest = interestExistRetrieveService.isExistInterest(postId, userId,
                postType);
        return ResponseEntity.ok(interest);
    }

}
