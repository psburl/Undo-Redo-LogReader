package PatternLogType;

import java.util.ArrayList;
import java.util.List;

import LogType.LogEntryType;

public class PatternsLogTypeMap {

    private static PatternsLogTypeMap instance = null;
    
    private List<PatternLogTypeMap> map;
    
    private PatternsLogTypeMap(){}
    
    public static PatternsLogTypeMap getInstance(){
        if(instance == null){
        	
            instance = new PatternsLogTypeMap();
            instance.map = new ArrayList<PatternLogTypeMap>();
            instance.map.add(new PatternLogTypeMap("<Start [^.]+>", LogEntryType.StartTransaction));
        }
        return instance;
    }
    
    public List<PatternLogTypeMap> getMap(){
    	return this.instance.map;
    }
}