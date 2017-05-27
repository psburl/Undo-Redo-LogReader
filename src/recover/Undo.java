package recover;

import globals.GlobalInfo;
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
			
			String currentValue = GlobalInfo.getInstance().getCurrentFeatureValue(log.getFeature());
			
			System.out.println(
					transaction + " undo recover are" + 
					" changing feature " + log.getFeature() + 
					" from value " + currentValue + 
					" to " + log.getOldValue());
			
			GlobalInfo.getInstance().changeFeature(log.getFeature(), log.getOldValue());
		}
		
		System.out.println("Finished " + transaction + " undo recover");
	}
}
