package globals;


import io.SingletonInput;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import logEntry.LogEntryType;
import logEntry.LogEntry;
import featureEntry.FeatureEntry;


public final class GlobalInfo {

    private static GlobalInfo instance = null;
    
    private GlobalInfo(){}
    
    private List<String> startedTransactions;
    private List<String> commitedTransactions;
    private List<FeatureEntry> features;
    private List<LogEntry> logs;
    private Semaphore semaphore = new Semaphore(1);
    
    
    public static GlobalInfo getInstance(){
        
    	if(instance == null){
        	
    		instance = new GlobalInfo();
    		instance.startedTransactions = new ArrayList<String>();
    		instance.commitedTransactions = new ArrayList<String>();
    		
    		instance.features = new ArrayList<FeatureEntry>();
    		for(String f : SingletonInput.getInstance().getFeatures()){
    			FeatureEntry feature = FeatureEntry.SerializeInput(f);
    			instance.features.add(feature);
    		}
    		
    		instance.logs = new ArrayList<LogEntry>();
    		
    		boolean hasEndCheck = false;
    		boolean onlyNeeds = false;
    		List<String> needs  = new ArrayList<String>();
    		
    		List<String> logs = SingletonInput.getInstance().getLogs();
    		for(int last = logs.size() -1; last >= 0; last--){
    			    			
    			LogEntry log = LogEntry.SerializeInput(logs.get(last));
    			
    			if(log.getLogEntryType() == LogEntryType.CheckpointEnd)
    				hasEndCheck = true;
    			
    			if(hasEndCheck && log.getLogEntryType() == LogEntryType.CheckpointStart){
    				onlyNeeds = true;
    				
    				for(String need : log.getInvolvedTransaction().split(","))
    					needs.add(need.trim());
    			}
    			
    			if(onlyNeeds == false || needs.contains(log.getInvolvedTransaction())){
    				
    				if(log.getLogEntryType() == LogEntryType.StartTransaction)
    					instance.setTransactionStart(log.getInvolvedTransaction());
    				
    				else if(log.getLogEntryType() == LogEntryType.CommitTransaction)
        				instance.setTransactionCommit(log.getInvolvedTransaction());
    			}
    			
    			instance.logs.add(0, log);
    		}
        }
        
        return instance;
    }
    
    public void setTransactionStart(String T){
    	if(instance.startedTransactions.contains(T) == false)
    		startedTransactions.add(T);
    }
    
    public void setTransactionCommit(String T){
    	if(instance.commitedTransactions.contains(T) == false)
    		commitedTransactions.add(T);
    }
    
    public List<String> geStartedTransactions(){
    	return instance.startedTransactions;
    }
    
    public List<String> geCommitedTransactions(){
    	return instance.commitedTransactions;
    }
    
    public String getCurrentFeatureValue(String id){
    	
    	for(FeatureEntry feature : instance.features){
    		if(feature.getFeature().equals(id)){
    			return feature.getValue();
    		}    			
    	}
    	
    	return "";
    }
    
    public void changeFeature(String id, String value){
    	
    	try{
    	
	    	instance.semaphore.acquire();
	    	for(FeatureEntry feature : instance.features){
	    		if(feature.getFeature().equals(id)){
	    			feature.setValue(value);
	    			break;
	    		}    			
	    	}
	    	instance.semaphore.release();    	

		} catch (InterruptedException e) {
			
			System.out.println(e.getMessage());
		}
    }
    
    public List<FeatureEntry> getFeatures(){
    	return instance.features;
    }
    
    public List<LogEntry> getLogs(){
    	return instance.logs;
    }
    
    public List<LogEntry> getTransactionLogs(String transaction){
    	
    	List<LogEntry> logs = new ArrayList<LogEntry>();
    	
    	for(LogEntry log : this.logs){
    		
    		String involvedTransaction = log.getInvolvedTransaction();
    		
    		if(involvedTransaction != null && involvedTransaction.equals(transaction))
    			logs.add(log);
    	}
    	
    	return logs;
    }
}