package logEntry;

import patternLogType.PatternLogTypeMap;
import patternLogType.SingletonPatternsLogTypeMap;

public abstract class LogEntry {
	
	protected LogEntryType entryType = LogEntryType.None;
	protected String involvedTransaction = "";
	protected String feature = "";
	protected String oldValue = "";
	protected String newValue = "";
	
	public static LogEntry SerializeInput(String input) {
		
		try {

			SingletonPatternsLogTypeMap instance = SingletonPatternsLogTypeMap.getInstance();

			PatternLogTypeMap logTypeMap = instance.findMatch(input);

			if(logTypeMap == null)
				throw new Exception("Pattern match not found to '" + input + "'");

			LogEntryType entryType = logTypeMap.getLogEntryType();

			switch(entryType){
				
				case StartTransaction: return new LogEntryStartTransaction(input);
				case CommitTransaction: return new LogEntryCommitTransaction(input);
				case Operation: return new LogEntryOperation(input);
				case CheckpointStart: return new LogEntryStartCheckpoint(input);
				case CheckpointEnd: return new LogEntryEndCheckpoint(input);
				default: throw new Exception("Has no factory to entry '" + entryType + "'");
			}

		}catch(Exception e){

			System.out.println(e.getMessage());
			printSerializeError(input);
			return null;
		}
	}

	private static void printSerializeError(String input){

		System.out.println("Invalid log input row detected! value: " + input);

		if(input.contains(">") == false)
			System.out.println("token '>' not found!");
		
		else if(input.contains("<") == false)
			System.out.println("token '<' not found!");
		
		else
			System.out.println("token '" + input.replace("<", "").replace(">", "") + "' can't be recognized!");
	}

	public LogEntryType getLogEntryType(){
		return this.entryType;
	}
	
	public String getInvolvedTransaction(){
		return this.involvedTransaction;
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
		
		if(involvedTransaction != null)
			System.out.println("Envolved Transaction: " + involvedTransaction);
		
		if(feature != null)
			System.out.println("Feature: " + feature);
		
		if(oldValue != null)
			System.out.println("Old value: " + oldValue);
		
		if(newValue != null)
			System.out.println("New value: " + newValue);
	}
}
