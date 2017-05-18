package PatternLogType;

import LogType.LogEntryType;

public class PatternLogTypeMap {

	private String pattern = "";
	private LogEntryType entryType;
	
	public PatternLogTypeMap(String pattern, LogEntryType type){
		
		this.entryType = type;
		this.pattern = pattern;
	}
	
	public String getpattern(){
		return this.pattern;
	}
	
	public LogEntryType getLogEntryType(){
		return this.entryType;
	}
}
