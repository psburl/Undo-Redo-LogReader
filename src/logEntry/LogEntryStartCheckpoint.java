package logEntry;

public final class LogEntryStartCheckpoint extends LogEntry{
	
	public LogEntryStartCheckpoint(String input){
		
		super.entryType = LogEntryType.CheckpointStart;
		super.feature = null;
		super.newValue = null;
		super.oldValue = null;
		super.involvedTransaction = input.replace("<Start CKPT(", "").replace("<start CKPT(", "").replace(")>","").trim();
	
	}
}
