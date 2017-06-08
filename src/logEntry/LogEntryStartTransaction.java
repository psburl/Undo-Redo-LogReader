package logEntry;

public final class LogEntryStartTransaction extends LogEntry{
	
	public LogEntryStartTransaction(String input){
		
		super.entryType = LogEntryType.StartTransaction;
		super.feature = null;
		super.newValue = null;
		super.oldValue = null;
		super.involvedTransaction = input.replaceAll("(?i)<Start", "").replace(">","").trim();
	}
}
