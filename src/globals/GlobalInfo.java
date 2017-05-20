package globals;

import java.util.ArrayList;
import java.util.List;


public final class GlobalInfo {

    private static GlobalInfo instance = null;
    
    private GlobalInfo(){}
    
    private List<String> startedTransactions;
    private List<String> commitedTransactions;
    
    
    public static GlobalInfo getInstance(){
        
    	if(instance == null){
        	
    		instance = new GlobalInfo();
    		instance.startedTransactions = new ArrayList<String>();
    		instance.commitedTransactions = new ArrayList<String>();
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
}