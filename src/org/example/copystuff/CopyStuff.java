package org.example.copystuff;

import java.io.*;
import org.apache.commons.cli.*;

public class CopyStuff {
	
    public static void main(String[] args) throws IOException, ParseException {
    	Options options = new Options();
    	options.addOption("i", true, "input file"); 
    	options.addOption("o", true, "output file");
    	CommandLineParser parser = new PosixParser();
    	CommandLine cmd = parser.parse(options, args);
        readNWrite(cmd); 
        
    }
    public static void readNWrite(CommandLine cmd) throws IOException{
    	InputStreamReader in = null;
    	OutputStreamWriter out = null;
    	
		try {
			if (cmd.hasOption("i")) {
				in = (InputStreamReader)new FileReader(cmd.getOptionValue("i"));
			} else {
				in = new InputStreamReader(System.in);
			}
			if (cmd.hasOption("o")){
				out = (OutputStreamWriter)new FileWriter(cmd.getOptionValue("o"));
			} else {
				out = new OutputStreamWriter(System.out);
			}
			
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}

		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
    }
}
