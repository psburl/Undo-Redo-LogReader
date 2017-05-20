package globals;

import input.SingletonInput;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

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
    		for(String l : SingletonInput.getInstance().getLogs()){
    			LogEntry log = LogEntry.SerializeInput(l);
    			instance.logs.add(log);
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
    
    public void ChangeFeature(String id, String value){
    	
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
}