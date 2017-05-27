package config;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public final class SingletonConfig {

    private static SingletonConfig instance = null;
    
    private SingletonConfig(){}
    
    private String inputPath = "";
    private String logPath = "";
    private String outputPath = "";
    
    public static SingletonConfig getInstance(){
        
    	if(instance == null){
        	
            instance = new SingletonConfig();
            
            try{
    			
    			File configFile = new File("../config.xml");
    			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    			DocumentBuilder builder = factory.newDocumentBuilder();
    			Document doc = builder.parse(configFile);
    			
    			Node node = doc.getElementsByTagName("paths").item(0);
    			Element element = (Element) node;
    			
    			instance.inputPath = element.getElementsByTagName("input").item(0).getTextContent();
    			instance.logPath = element.getElementsByTagName("log").item(0).getTextContent();
    			instance.outputPath = element.getElementsByTagName("output").item(0).getTextContent();
    			
    		} catch (Exception e) {
    			
    			System.out.println("Exception getting Config File. Path: " + e.getMessage());
    		}
        }
        
        return instance;
    }
    
    public String getInputPath(){
    	return instance.inputPath;
    }
    
    public String getOutputPath(){
    	return instance.outputPath;
    }
    
    public String getLogPath(){
    	return instance.logPath;
    }
}