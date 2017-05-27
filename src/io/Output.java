package io;

import featureEntry.FeatureEntry;
import globals.GlobalInfo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import config.SingletonConfig;

public class Output {

	public static void Update(){
		
		try {
						
			File file = new File(SingletonConfig.getInstance().getOutputPath());
			file.createNewFile();
			file.setWritable(true);
			
			PrintWriter pw = new PrintWriter(file);
			pw.close();
			
			FileWriter fw = new FileWriter(file);
						
			for(FeatureEntry f : GlobalInfo.getInstance().getFeatures()){
				fw.write(f.getFeature() + "=" + f.getValue() + "\r\n");
			}
			
			fw.flush();
			fw.close();

    	} catch (IOException e) {
		      e.printStackTrace();
		}		
	}
}
