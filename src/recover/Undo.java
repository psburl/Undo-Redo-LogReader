package recover;

import globals.GlobalInfo;

import java.util.List;

import logEntry.LogEntry;
import logEntry.LogEntryType;

public final class Undo extends Recover{

	public Undo(String transaction){
		this.transaction = transaction;
	}
	
	public void run() {

		System.out.println("Starting Undo on " + transaction);
		
		for(int i = this.involvedLogs.size() - 1; i >= 0; i--){
			
			LogEntry log = involvedLogs.get(i);
			
			LogEntryType type = log.getLogEntryType();
			
			if(type == LogEntryType.StartTransaction)
				break;
			
			if(type != LogEntryType.Operation)
				continue;
			
			GlobalInfo.getInstance().ChangeFeature(log.getFeature(), log.getOldValue());
		}
	}
}
