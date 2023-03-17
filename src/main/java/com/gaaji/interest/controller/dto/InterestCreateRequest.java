package com.gaaji.interest.controller.dto;

import com.gaaji.interest.domain.PostType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InterestCreateRequest {

    private String postId;
    private PostType postType;


}
