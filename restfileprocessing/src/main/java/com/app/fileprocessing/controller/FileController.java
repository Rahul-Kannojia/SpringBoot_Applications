package com.app.fileprocessing.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {
	@Value("${uploadUrl}")
	private String UPLOAD_DIR;
	
	@PostMapping("/upload")
	public boolean fileUpload(@RequestParam("file")MultipartFile file){
		try {
			file.transferTo(new File(UPLOAD_DIR + file.getOriginalFilename()));
		} catch (IllegalStateException | IOException ex) {
			System.err.println(ex);
		} 
		return true;
	}
	
	@GetMapping("/download/{fileName}")
	public ResponseEntity<byte[]> downloadFile(@PathVariable("fileName")String fileName){
		byte[] fileData = null;
		HttpHeaders headers = null;
		try {
			fileData = Files.readAllBytes(new File(UPLOAD_DIR+fileName).toPath());
			headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_PNG);
			
		} catch (IOException ex) {
			System.err.print(ex);
		}
		return new ResponseEntity<byte[]>(fileData,headers,HttpStatus.OK) ;
	}

}
