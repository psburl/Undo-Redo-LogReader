package patternLogType;

import java.util.ArrayList;
import java.util.List;

import logEntry.LogEntryType;

public class SingletonPatternsLogTypeMap {

    private static SingletonPatternsLogTypeMap instance = null;
    
    private List<PatternLogTypeMap> map;
    
    private SingletonPatternsLogTypeMap(){}
    
    public static SingletonPatternsLogTypeMap getInstance(){
        
    	if(instance == null){
        	
            instance = new SingletonPatternsLogTypeMap();
            instance.map = new ArrayList<PatternLogTypeMap>();
            instance.map.add(new PatternLogTypeMap("<(S|s)tart [^.]+>", LogEntryType.StartTransaction));
            instance.map.add(new PatternLogTypeMap("<(C|c)ommit [^.]+>", LogEntryType.CommitTransaction));
            instance.map.add(new PatternLogTypeMap("<[^,]+,[^,]+,[^,]+,[^,]+>", LogEntryType.Operation));
        }
        return instance;
    }
    
    public List<PatternLogTypeMap> getMap(){
    	return getInstance().map;
    }
}