package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import config.SingletonConfig;

public final class SingletonInput {

    private static SingletonInput instance = null;
    
    private SingletonInput(){}
    
    private List<String> features;
    private List<String> logs;
    
    public static SingletonInput getInstance(){
        
    	if(instance == null){
        	
            instance = new SingletonInput();
            instance.features = openFeatures();
            instance.logs = openLogs();
        }
        
        return instance;
    }
    
    private static List<String> openLogs(){
    	
    	try{
    		String content = readFile(SingletonConfig.getInstance().getLogPath());
    		
    		if(content.equals(""))
    			throw new Exception("Error while open logs input");
    		
    		return Arrays.asList(content.split("\n"));
    		
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    		return null;
    	}
    }
    
    private static List<String> openFeatures(){
    	
    	try{
    		String content = readFile(SingletonConfig.getInstance().getInputPath());
    		
    		if(content.equals(""))
    			throw new Exception("Error while open features input");
    		
    		return Arrays.asList(content.split("\n"));
    		
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    		return null;
    	}
    }
    
    private static String readFile(String path){
    	
    	try{
    		return new String(Files.readAllBytes(Paths.get(path)));
    	}
    	catch(IOException e){
    		System.out.println("Exception opening file. Path: " + e.getMessage());
    		return "";
    	}
    }
    
    public List<String> getLogs(){
    	return instance.logs;
    }
    
    public List<String> getFeatures(){
    	return instance.features;
    }
}