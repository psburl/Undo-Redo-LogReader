package input;

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
            
            String content = ReadFile(SingletonConfig.getInstance().getInputPath());
            instance.features = Arrays.asList(content.split("\r\n"));
            
            content = ReadFile(SingletonConfig.getInstance().getLogPath());
            instance.logs = Arrays.asList(content.split("\r\n"));
        }
        
        return instance;
    }
    
    private static String ReadFile(String path){
    	
    	try{
    		return new String(Files.readAllBytes(Paths.get(path)));
    	}
    	catch(IOException e){
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