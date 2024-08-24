package com.codelab.restOnlineLibrary.aws;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Component
public class S3Config {

	@Value("${aws.access.key.id}")
	private String awsAccessKeyId;

	@Value("${aws.secret.access.key}")
	private String awsSecretAccessKey;

	@Value("${aws.region}")
	private String awsRegion;

	@PostConstruct
	public void printEnvironmentVariables() {
		System.out.println("AWS Access Key ID: " + awsAccessKeyId);
		System.out.println("AWS Secret Access Key: " + awsSecretAccessKey);
		System.out.println("AWS Region: " + awsRegion);
	}

	@Bean
	public S3Client s3Client() {
		AwsBasicCredentials awsCreds = AwsBasicCredentials.create(awsAccessKeyId, awsSecretAccessKey);
		return S3Client.builder().region(Region.of(awsRegion))
				.credentialsProvider(StaticCredentialsProvider.create(awsCreds)).build();
	}

}