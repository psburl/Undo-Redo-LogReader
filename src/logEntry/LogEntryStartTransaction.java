package logEntry;

import globals.GlobalInfo;

public final class LogEntryStartTransaction extends LogEntry{
	
	public LogEntryStartTransaction(String input){
		
		super.entryType = LogEntryType.StartTransaction;
		super.feature = null;
		super.newValue = null;
		super.oldValue = null;
		super.involvedTransaction = input.replace("<Start", "").replace("<start", "").replace(">","").trim();
		GlobalInfo.getInstance().setTransactionStart(super.involvedTransaction);
	}
}
