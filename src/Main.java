import io.Output;
import java.util.ArrayList;
import java.util.List;
import recover.Recover;
import globals.GlobalInfo;

public class Main {

	public static void main(String[] args) throws InterruptedException{
		
		List<Thread> threads = new ArrayList<Thread>();

		for(String t : GlobalInfo.getInstance().geStartedTransactions()){		
			
			Recover operation = Recover.decide(t);
			
			Thread th = new Thread(operation);
			threads.add(th);
			th.start();
		}

		for(Thread t : threads)
			t.join();
			
		Output.Update();
	}
}
