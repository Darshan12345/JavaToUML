package com.company;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

import net.sourceforge.plantuml.SourceStringReader;
import net.sourceforge.plantuml.*;

public class ImageGenerator {

	
	public  void imageConverter(String source) throws Throwable
	{
		final ByteArrayOutputStream bous = new ByteArrayOutputStream();

	

		SourceStringReader reader = new SourceStringReader(source);
		// Write the first image to "os"
		String desc = reader.generateImage(bous);

		//return a null string if no generation
		
		byte []data=bous.toByteArray();
		InputStream in= new ByteArrayInputStream(data);
		
		BufferedImage convImg=ImageIO.read(in);
		
		ImageIO.write(convImg, "png",new File("C:\\Users\\darshan\\Desktop\\image3.png"));
		System.out.println(desc+"from image class");
				
		
	}
}
