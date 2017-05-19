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
					case CommitTransaction: return new LogEntryCommitTransaction(input);
					case Operation: return new LogEntryOperation(input);
					default: return null;
				}
			}
		}
		
		System.out.println("Invalid log input row detected! value: " + input);
		
		if(input.contains(">") == false)
			System.out.println("token '>' not found!");
		
		else if(input.contains("<") == false)
			System.out.println("token '<' not found!");
		else
			System.out.println("token '" + input.replace("<", "").replace(">", "") + "' can't be recognized!");
		
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
	
	public void Print()
	{
		if(entryType != null)
			System.out.println("Log type: " + entryType);
		
		if(envolvedTransaction != null)
			System.out.println("Envolved Transaction: " + envolvedTransaction);
		
		if(feature != null)
			System.out.println("Feature: " + feature);
		
		if(oldValue != null)
			System.out.println("Old value: " + oldValue);
		
		if(newValue != null)
			System.out.println("New value: " + newValue);
	}
}
