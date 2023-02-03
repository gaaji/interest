package com.gaaji.interest.adaptor;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("used-item-service")
public interface UsedItemServiceClient {

    @GetMapping("/foo/bar")
    boolean isExistPostId(String postId);
}
