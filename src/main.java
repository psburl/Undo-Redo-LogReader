import logEntry.LogEntry;

public class main {

	public static void main(String[] args) {

		String line = "<Start a>";
				
		LogEntry entry = LogEntry.SerialiazeInput(line);
		
		entry.Print();
	}
}
