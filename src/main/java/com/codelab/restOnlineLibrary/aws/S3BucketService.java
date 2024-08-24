package com.codelab.restOnlineLibrary.aws;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import software.amazon.awssdk.services.s3.model.CreateBucketResponse;
import software.amazon.awssdk.services.s3.model.ListBucketsRequest;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;
import software.amazon.awssdk.services.s3.model.S3Exception;

@Service
public class S3BucketService {

	private final S3Client s3Client;

	@Value("${aws.s3.bucket.name}")
	private String bucketName;

	public S3BucketService(S3Client s3Client) {
		this.s3Client = s3Client;
	}

	public void createBucketIfNotExists() {
		try {
			ListBucketsRequest listBucketsRequest = ListBucketsRequest.builder().build();
			ListBucketsResponse listBucketsResponse = s3Client.listBuckets(listBucketsRequest);

			boolean bucketExists = listBucketsResponse.buckets().stream()
					.anyMatch(bucket -> bucket.name().equals(bucketName));

			if (!bucketExists) {
				CreateBucketRequest createBucketRequest = CreateBucketRequest.builder().bucket(bucketName).build();

				CreateBucketResponse createBucketResponse = s3Client.createBucket(createBucketRequest);
				System.out.println("Bucket created successfully: " + createBucketResponse.location());
			} else {
				System.out.println("Bucket already exists: " + bucketName);
			}

		} catch (S3Exception e) {
			e.printStackTrace();
			System.err.println("Error managing bucket: " + e.getMessage());
		}
	}
}