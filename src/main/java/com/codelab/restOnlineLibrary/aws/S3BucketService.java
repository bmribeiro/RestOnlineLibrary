package com.codelab.restOnlineLibrary.aws;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.codelab.restOnlineLibrary.entities.BookDetail;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import software.amazon.awssdk.services.s3.model.CreateBucketResponse;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetUrlRequest;
import software.amazon.awssdk.services.s3.model.ListBucketsRequest;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;
import software.amazon.awssdk.services.s3.model.S3Object;

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

	public void uploadImageToS3(BookDetail bookDetail) throws IOException {

		// Decodes Base64 string to bytes
		byte[] imageBytes = removeBase64Prefix(bookDetail.getImageBase64());

		// Create a temporary file
		File tempFile = File.createTempFile("tempImage", ".tmp");

		// Write bytes to the temporary file
		try (FileOutputStream fos = new FileOutputStream(tempFile)) {
			fos.write(imageBytes);
		}

		// Sets the key for the object in S3
		String key = "books/" + bookDetail.getBook().getId() + "/" + bookDetail.getImageFilename();

		// Create the request for S3
		PutObjectRequest putObjectRequest = PutObjectRequest.builder().bucket(bucketName).key(key).build();

		// Upload the file to S3
		s3Client.putObject(putObjectRequest, RequestBody.fromFile(tempFile));

		// Delete temporary file after upload
		tempFile.delete();
	}

	// Clean base64
	private byte[] removeBase64Prefix(String imageBase64) {

		String base64ImageClean = imageBase64;
		if (base64ImageClean.startsWith("data:image/")) {
			int commaIndex = base64ImageClean.indexOf(',');
			if (commaIndex >= 0) {
				base64ImageClean = base64ImageClean.substring(commaIndex + 1);
				System.out.println(base64ImageClean);
			}
		}
		return Base64.getDecoder().decode(base64ImageClean);
	}

	public String generateImageUrl(BookDetail bookDetail) {
		
	    // Builds the image key
	    String key = "books/" + bookDetail.getBook().getId() + "/" + bookDetail.getImageFilename();

	    // Generates and returns the image URL
	    return s3Client.utilities().getUrl(GetUrlRequest.builder()
	        .bucket(bucketName)
	        .key(key)
	        .build()).toString();
	}

}