package com.company;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.lang.reflect.Member;
import static java.lang.System.out;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;


public class GenerateImageString {
 Class<?>c;
	int a;
	public  String UMLString(String path) throws Throwable
	{
	
	System.setProperty("java.home", "C:\\Program Files\\Java\\jdk1.8.0_121");
		
	File file=new File(path);
		
	System.out.println(path);
		// Compile source file.
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		compiler.run(null, null, null, file.getPath());
		// Load and instantiate compiled class.
		
		System.out.println(file.getParentFile());
		String classname=file.getName().replace(".java","");
	//	System.out.println(classname);
		//System.out.println(file.getParentFile().toURI().toURL());
		URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { file.getParentFile().toURI().toURL() });
		
		try {
			
			
			c = Class.forName(classname, true, classLoader);
			
			getclassdetail();
			source+="}";
			source += "\n@enduml";
			
			
		//ImageGenerator img=new ImageGenerator();
		//img.imageConverter(source);
			System.out.println(source);
			
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Should print "hello".
	
		return source;
	}



	 String source="@startuml\n";


	
	public  void getclassdetail() throws Exception{
		
		getClassname();
		getField();
	}
	
	public  void getClassname() throws ClassNotFoundException{
		
		    source+= "class "+c.getCanonicalName()+"{\n";

	}

	
public  void getField()

	{
		Field[] fields = c.getDeclaredFields();
		
		for (int i = 0; i < fields.length; i++) {
		      Field f = fields[i];
		      Class type = f.getType();
		      String name = f.getName();
		      //add Modifier to variable
		      
		      
		      getVariableTypeName(type, name,f);
		
		    //  getModifier(f);
			   
		
		      
		      if(type.isArray()){
		    	
		    	  getArrayTypeName(type.getComponentType(),f.getName(),f);
		      }
		      
		    
		    }
		
		
	}

	 
	public  void getArrayTypeName(Class type,String name,Field f)
	{
		
		boolean isVariable=false;
		String attach_variable="";
		
		if(type.equals(int.class)){
		attach_variable="Int[] "+name +"\n";
		isVariable=true;
		}
		else if(type.equals(byte.class)){
			attach_variable="byte[] "+name +"\n";
			isVariable=true;
		}
		else if(type.equals(String.class)){
			attach_variable="String[] "+name +"\n";
			isVariable=true;
		}
		else if(type.equals(double.class)){
			attach_variable="double[] "+name +"\n";
			isVariable=true;
		}
	
		else if(type.equals(float.class)){
			attach_variable="float[] "+name +"\n";
			isVariable=true;
		}
		
		else if(type.equals(boolean.class)){
			attach_variable="boolean[] "+name +"\n";
			isVariable=true;
			
		}
		
		if(isVariable){
			getModifier(f);
			source+=attach_variable;
			
		}

		
	}
	public void getvariableName(String name)
	{
		source+=name+";"+"\n";
	}
	public  void getVariableTypeName(Class type,String name, Field f)
	{
		boolean isVariable=false;
		String attach_variable="";
		
		if(type.equals(int.class)){
		attach_variable="Int "+name +"\n";
		isVariable=true;
		}
		else if(type.equals(byte.class)){
			attach_variable="byte "+name +"\n";
			isVariable=true;
		}
		else if(type.equals(String.class)){
			attach_variable="String "+name +"\n";
			isVariable=true;
		}
		else if(type.equals(double.class)){
			attach_variable="double "+name +"\n";
			isVariable=true;
		}
	
		else if(type.equals(float.class)){
			attach_variable="float "+name +"\n";
			isVariable=true;
		}	else if(type.equals(boolean.class)){
			attach_variable="float "+name +"\n";
			isVariable=true;
		}
		
		if(isVariable){
			getModifier(f);
			source+=attach_variable;
			
		}
	}
	public  void getModifier(Field f){
		Class c=f.getType();
		int value=f.getModifiers();
		String variable_name=f.getName();
		boolean isStatic=false;
		boolean isFinal=false;
		//default Modifier
		
		
		boolean isVariable=false;
			if(Modifier.isFinal(f.getModifiers())){
				isFinal=true;
			
			}
			if(Modifier.isStatic(f.getModifiers())){
				isStatic=true;
			}
			
		

		
		//public Modifier
		if(Modifier.isPublic(f.getModifiers()))
		{
			source+="+";
			isVariable=true;
		}
		//private MOdifier
		else if(Modifier.isPrivate(f.getModifiers())){
			source+="-";
			isVariable=true;
		}
		//protected Modifier
		else if(Modifier.isProtected(f.getModifiers())){
			source+="#";
			isVariable=true;
		}
		else {
			isVariable=true;
			source+="~";
			
		}
		
	
		
		if(isVariable){
			if(isFinal){
				source+="final ";
			}
			if(isStatic){
				source+="static ";
					
			}
			//getVariableTypeName(c, f.getName());
		}
		
	}
}

