package com.gaaji.interest.adaptor;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("used-item-service")
public interface UsedItemServiceClient {
    @GetMapping("/posts/exist/{postId}")
    boolean isExistPostId(@PathVariable("postId") String postId);
}
