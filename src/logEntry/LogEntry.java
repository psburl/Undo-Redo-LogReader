package logEntry;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import patternLogType.PatternLogTypeMap;
import patternLogType.SingletonPatternsLogTypeMap;

public abstract class LogEntry {
	
	protected LogEntryType entryType = LogEntryType.None;
	protected String envolvedTransaction = "";
	protected String feature = "";
	protected String oldValue = "";
	protected String newValue = "";
	
	public static LogEntry SerialiazeInput(String input){
		
		for(PatternLogTypeMap map : SingletonPatternsLogTypeMap.getInstance().getMap()){
			
			Pattern pattern = Pattern.compile(map.getpattern());
			Matcher matcher = pattern.matcher(input);
			
			if(matcher.find()){
				
				switch(map.getLogEntryType()){
					
					case StartTransaction: return new LogEntryStartTransaction(input);
					default: return null;
				}
			}
		}
		
		return null;
	}

	public LogEntryType getLogEntryType(){
		return this.entryType;
	}
	
	public String getEnvolvedTransaction(){
		return this.envolvedTransaction;
	}
	
	public String getFeature(){
		return this.feature;
	}
	
	public String getOldValue(){
		return this.oldValue;
	}
	
	public String getNewValue(){
		return this.newValue;
	}
}
