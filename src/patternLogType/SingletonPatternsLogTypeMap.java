package patternLogType;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import logEntry.LogEntryType;

public final class SingletonPatternsLogTypeMap {

    private static SingletonPatternsLogTypeMap instance = null;
    
    private List<PatternLogTypeMap> map;
    
    private SingletonPatternsLogTypeMap(){}
    
    public static SingletonPatternsLogTypeMap getInstance(){
        
    	if(instance == null){
        	
            instance = new SingletonPatternsLogTypeMap();
            instance.map = new ArrayList<PatternLogTypeMap>();
            instance.map.add(new PatternLogTypeMap("^<start CKPT\\([^.]+\\)>", LogEntryType.CheckpointStart));
            instance.map.add(new PatternLogTypeMap("^<start [^.]+>", LogEntryType.StartTransaction));
            instance.map.add(new PatternLogTypeMap("^<commit [^.]+>", LogEntryType.CommitTransaction));
            instance.map.add(new PatternLogTypeMap("^<[^,]+,[^,]+,[^,]+,[^,]+>", LogEntryType.Operation));
            instance.map.add(new PatternLogTypeMap("^<end CKPT>", LogEntryType.CheckpointEnd));
        }
        
        return instance;
    }
    
    public List<PatternLogTypeMap> getMap(){
    	return getInstance().map;
    }

    public PatternLogTypeMap findMatch(String input){

        for(PatternLogTypeMap map : getInstance().getMap()){

            Pattern pattern = Pattern.compile(map.getpattern(), Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            
            if(matcher.find())
                return map;
        }

        return null;
    }
}