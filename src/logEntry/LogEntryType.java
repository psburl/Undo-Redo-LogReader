package logEntry;

public enum LogEntryType {

	StartTransaction	(true),
	CommitTransaction	(true),
	CheckpointStart	    (true),
	CheckpointEnd		(true),
	Operation			(true),
	None				(false);
	
	LogEntryType(boolean isValid){
		this.isValid = isValid;
	}
	
	private boolean isValid = false;
	
	public boolean isValid(){
		return isValid;
	}
}
