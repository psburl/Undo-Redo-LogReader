import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import PatternLogType.PatternLogTypeMap;
import PatternLogType.PatternsLogTypeMap;

public class main {

	public static void main(String[] args) {

		String line = "<Start T>";
		
		List<String> patterns = Arrays.asList("<Start [^.]+>", "<[^,]+,[^,]+,[^,]+,[^,]+>");
		
		for(PatternLogTypeMap map : PatternsLogTypeMap.getInstance().getMap()){
			
			Pattern r = Pattern.compile(map.getpattern());
			
			Matcher m = r.matcher(line);
			
			if(m.find()){
				
				System.out.println(map.getLogEntryType());
			}
		}
	}
}
