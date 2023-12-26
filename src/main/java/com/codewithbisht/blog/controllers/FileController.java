package com.codewithbisht.blog.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.codewithbisht.blog.payloads.FileResponse;
import com.codewithbisht.blog.services.FileService;

@RestController
@RequestMapping("/file")
public class FileController 
{
	@Autowired
	private FileService fileService;
	
	@Value("${project.image}")
	private String path;
	
	@PostMapping("/upload")
	public ResponseEntity<FileResponse> fileUpload(@RequestParam("image") MultipartFile image)
	{
		String fileName;
		try {
			fileName = this.fileService.uploadImage(path, image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(new FileResponse(null,"Image not uploaded"),HttpStatus.INTERNAL_SERVER_ERROR);	

		}
		return new ResponseEntity<>(new FileResponse(fileName,"Image successfully uploaded"),HttpStatus.OK);	

	}
	
}
