package com.my.upload;

import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {
	@Override
	public File rename(File file) {
		System.out.println("기본파일명=" + file.getName());
		String name = file.getName(); //eg)정리.png
		int index = name.indexOf(".");
		String fileName = name.substring(0, index);
		String ext = name.substring(index, name.length());
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyyMMddHHmmss");		
		String time = "-" + sdf.format(new Date()); 
		 //-년월일시분초  eg) 정리-20160812143500.png 
		name = fileName + time + ext;
		return new File(file.getParentFile(),name);
	}
}