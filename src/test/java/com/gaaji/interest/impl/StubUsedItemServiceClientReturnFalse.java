package com.gaaji.interest.impl;

import com.gaaji.interest.adaptor.UsedItemServiceClient;

public class StubUsedItemServiceClientReturnFalse implements UsedItemServiceClient {

    @Override
    public boolean isExistPostId(String postId) {

        return false;
    }
}
