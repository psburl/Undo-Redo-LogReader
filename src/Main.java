import java.util.ArrayList;
import java.util.List;
import recover.Recover;
import featureEntry.FeatureEntry;
import globals.GlobalInfo;

public class Main {

	public static void main(String[] args) {
		
		List<Thread> threads = new ArrayList<Thread>();
				
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
		
		for(FeatureEntry f : GlobalInfo.getInstance().getFeatures()){
			f.Print();
			System.out.println("----------------");
		}
	}
}
