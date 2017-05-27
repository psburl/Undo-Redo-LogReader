package recover;

import globals.GlobalInfo;
import logEntry.LogEntry;
import logEntry.LogEntryType;

public final class Redo extends Recover {

	public Redo(String transaction){
		this.transaction = transaction;
	}
	
	public void run() {
		
		System.out.println("Starting Redo on " + transaction);
		
		for(LogEntry log : this.involvedLogs){
			
			LogEntryType type = log.getLogEntryType();
						
			if(type != LogEntryType.Operation)
				continue;			
			
			String currentValue = GlobalInfo.getInstance().getCurrentFeatureValue(log.getFeature());
			
			System.out.println(
					transaction + " undo recover are" + 
					" changing feature " + log.getFeature() + 
					" from value " + currentValue + 
					" to " + log.getNewValue());
			
			GlobalInfo.getInstance().changeFeature(log.getFeature(), log.getNewValue());
		}
		
		System.out.println("Finished " + transaction + " redu recover");
	}
}
