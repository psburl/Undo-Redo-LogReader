import java.util.ArrayList;
import java.util.List;
import recover.Recover;
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
		
		List<Thread> threads = new ArrayList<Thread>();
		
		for(FeatureEntry e :  GlobalInfo.getInstance().getFeatures())
			System.out.println(e.getFeature() + "=" + e.getValue());
		
		for(String t : GlobalInfo.getInstance().geStartedTransactions()){
			
			Recover operation = Recover.decide(t);
			
			Thread th = new Thread(operation);
			threads.add(th);
			th.start();
		}
		try {
			
			for(Thread t : threads){
				t.join();
			}
			
		} catch (InterruptedException E) {
			   // handle
		}
		
		for(FeatureEntry e :  GlobalInfo.getInstance().getFeatures())
			System.out.println(e.getFeature() + "=" + e.getValue());
	}
}
