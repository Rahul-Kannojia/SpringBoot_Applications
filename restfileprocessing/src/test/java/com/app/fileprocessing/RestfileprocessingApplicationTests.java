package com.app.fileprocessing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class RestfileprocessingApplicationTests {
	
	private static final String DOWNLOAD_PATH = "C:/Users/rahul/OneDrive/Documents/FileUploaded";
	private static final String FILE_UPLOAD_URL = "http://localhost:8081/fileprocessing/upload";
	private static final String FILE_DOWNLOAD_URL ="http://localhost:8081/fileprocessing/download/";

	@Autowired
	RestTemplate restTemplate;
	
	@Test
	void testFileUpload() {
		// Form Data
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		// Body
		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("file", new ClassPathResource("1.png"));
		
		//HttpEntity is used to pass in RestTemplate
		HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(body,headers); 
		// Doing RestCall (for Uploading use postForEntity())
		ResponseEntity<Boolean> response = restTemplate.postForEntity(FILE_UPLOAD_URL, entity, Boolean.class);
		System.out.println(response.getBody());
	}
	
	@Test
	void testFileDownload() throws IOException {
		/**
		 * Here we are Accepting List and 
		 * In List we are accepting Binary data so MediaType is OCTET_STREAM 
		 * */
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_OCTET_STREAM));
		
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		String fileName = "1.png";
		/**
		 * Here we are doing RestCall to get File
		 * */
		ResponseEntity<byte[]> response = restTemplate.exchange(FILE_DOWNLOAD_URL+fileName, HttpMethod.GET, entity, byte[].class);
		
		/**
		 *Now we to write the File at a Location "C:/Users/rahul/OneDrive/Documents/FileUploaded"
		 * */
		
		Files.write(Paths.get(DOWNLOAD_PATH+fileName), response.getBody());
		
	}

}
