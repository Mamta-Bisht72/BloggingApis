package com.codewithbisht.blog.services.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.codewithbisht.blog.services.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException  {
		
		// File Name
		String name=file.getOriginalFilename();
		//Random name generate if file name is same for those case
		String randomID=UUID.randomUUID().toString();
		//Full Path
		String fileName=randomID.concat(name.substring(name.lastIndexOf(".")));
		String filePath=path+File.separator+fileName;
		//Create folder if not created
		
		File f=new File(path);
		if(!f.exists())
		{
			f.mkdir();
		}
		//file copy
		Files.copy(file.getInputStream(),Paths.get(filePath));
		
		return name;
	}

	/*@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}*/

}
