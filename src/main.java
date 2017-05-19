import logEntry.LogEntry;

public class main {

	public static void main(String[] args) {

		String line = "<ftart start>";
				
		LogEntry entry = LogEntry.SerialiazeInput(line);
		
		entry.Print();
	}
}
