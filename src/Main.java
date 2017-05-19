import java.util.List;

import featureEntry.FeatureEntry;
import input.SingletonInput;
import logEntry.LogEntry;


public class Main {

	public static void main(String[] args) {
		
		
		List<String> logs = SingletonInput.getInstance().getLogs();
		
		for(String log : logs){
			
			LogEntry entry = LogEntry.SerializeInput(log);
			entry.Print();
			
			System.out.println("---------------------------");
		}
		
		List<String> features = SingletonInput.getInstance().getFeatures();
		
		for(String feature : features){
			
			FeatureEntry entry = FeatureEntry.SerializeInput(feature);
			entry.Print();
			
			System.out.println("---------------------------");
		}
	}
}
