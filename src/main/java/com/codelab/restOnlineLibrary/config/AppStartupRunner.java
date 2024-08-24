package com.codelab.restOnlineLibrary.config;

import org.springframework.stereotype.Component;

import com.codelab.restOnlineLibrary.aws.S3BucketService;

import jakarta.annotation.PostConstruct;

@Component
public class AppStartupRunner {

    private final S3BucketService s3BucketService;

    public AppStartupRunner(S3BucketService s3BucketService) {
        this.s3BucketService = s3BucketService;
    }

    @PostConstruct
    public void onStartup() {
        s3BucketService.createBucketIfNotExists();
    }
}