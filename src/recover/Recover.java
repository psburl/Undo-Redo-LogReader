package recover;

import java.util.List;

import logEntry.LogEntry;

import globals.GlobalInfo;

public abstract class Recover implements Runnable{
	
	protected String transaction;
	protected List<LogEntry> involvedLogs;
	
	public static Recover decide(String transaction){
		
		Recover recover;
		
		
		if(GlobalInfo.getInstance().geCommitedTransactions().contains(transaction))
			recover = new Redo(transaction);
		
		else
			recover = new Undo(transaction);
		
		recover.involvedLogs = GlobalInfo.getInstance().getTransactionLogs(transaction);
	

		return recover;
		
	}
}
