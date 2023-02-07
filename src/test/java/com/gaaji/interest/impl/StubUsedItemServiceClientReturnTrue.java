package com.gaaji.interest.impl;

import com.gaaji.interest.adaptor.UsedItemServiceClient;

public class StubUsedItemServiceClientReturnTrue implements UsedItemServiceClient {

    @Override
    public boolean isExistPostId(String postId) {
        return true;
    }
}
