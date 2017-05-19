package logEntry;

public class LogEntryCommitTransaction extends LogEntry {
	
	public LogEntryCommitTransaction(String input){
		
		super.entryType = LogEntryType.CommitTransaction;
		super.feature = null;
		super.newValue = null;
		super.oldValue = null;
		super.envolvedTransaction = input.replace("<Commit", "").replace("<commit", "").replace(">","").trim();
	}
}
