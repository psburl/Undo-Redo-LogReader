package logEntry;

import java.util.Arrays;
import java.util.List;

public class LogEntryOperation extends LogEntry{
	
	public LogEntryOperation(String input){
		
		input = input.replace("<", "").replace(">", "");
		
		List<String> entries = Arrays.asList(input.split(","));
		
		super.entryType = LogEntryType.Operation;
		super.feature = entries.get(1).trim();
		super.oldValue = entries.get(2).trim();
		super.newValue = entries.get(3).trim();
		super.involvedTransaction = entries.get(0).trim();
	}
}
