package logEntry;

public final class LogEntryEndCheckpoint extends LogEntry{
	
	public LogEntryEndCheckpoint(String input){
		
		super.entryType = LogEntryType.CheckpointEnd;
		super.feature = null;
		super.newValue = null;
		super.oldValue = null;
		super.involvedTransaction = null;
	}
}
