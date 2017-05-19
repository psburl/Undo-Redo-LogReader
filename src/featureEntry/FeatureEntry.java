package featureEntry;

import java.util.Arrays;
import java.util.List;

public final class FeatureEntry {
	
	private String feature = "";
	private String value = "";
	
	public FeatureEntry(){}
	
	public static FeatureEntry SerializeInput(String input){
		
		List<String> entries = Arrays.asList(input.split("="));
		
		FeatureEntry entry = new FeatureEntry();
		entry.feature = entries.get(0);
		entry.value = entries.get(1);
		return entry;
	}
	
	public String getFeature(){
		return this.feature;
	}
	
	public String getValue(){
		return this.value;
	}
	
	public void Print(){
		
		System.out.println("Feature: " + this.feature);
		System.out.println("Value: " + this.value);
	}
}
