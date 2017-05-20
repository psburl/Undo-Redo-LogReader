package logEntry;

import globals.GlobalInfo;

public class LogEntryCommitTransaction extends LogEntry {
	
	public LogEntryCommitTransaction(String input){
		
		super.entryType = LogEntryType.CommitTransaction;
		super.feature = null;
		super.newValue = null;
		super.oldValue = null;
		super.involvedTransaction = input.replace("<Commit", "").replace("<commit", "").replace(">","").trim();
		GlobalInfo.getInstance().setTransactionCommit(super.involvedTransaction);
	}
}
