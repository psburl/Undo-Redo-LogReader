import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import logEntry.LogEntry;
import patternLogType.PatternLogTypeMap;
import patternLogType.SingletonPatternsLogTypeMap;

public class main {

	public static void main(String[] args) {

		String line = "<Start T>";
				
		LogEntry entry = LogEntry.SerialiazeInput(line);
		
		System.out.println(entry.getEnvolvedTransaction());
	}
}
