import java.util.List;

import featureEntry.FeatureEntry;
import globals.GlobalInfo;
import input.SingletonInput;
import logEntry.LogEntry;


public class Main {

	public static void main(String[] args) {
		
		
		List<String> logs = SingletonInput.getInstance().getLogs();
		
		for(String log : logs){
			
			LogEntry entry = LogEntry.SerializeInput(log);
		}
		
		for(String s : GlobalInfo.getInstance().geStartedTransactions())
			System.out.println("Start " + s);
		

		for(String s : GlobalInfo.getInstance().geCommitedTransactions())
			System.out.println("Commit " + s);
	}
}
