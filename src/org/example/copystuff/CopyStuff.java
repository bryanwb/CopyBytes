package org.example.copystuff;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

public class CopyStuff {
	
    public static void main(String[] args) throws IOException, ParseException {
    	Options options = new Options();
    	options.addOption("i", true, "input file"); 
    	options.addOption("o", true, "output file");
    	CommandLineParser parser = new PosixParser();
    	CommandLine cmd = parser.parse(options, args);
        readNWrite(cmd); 
        
    }
    public static void readNWrite(CommandLine cmd){
    	
		try {
			if (cmd.hasOption("i")) {
				FileReader in = (new FileReader(cmd.getOptionValue("i")));
			} else {
				InputStream in = System.in;
			}
			if (cmd.hasOption("o")){
				FileWriter out = new FileWriter(cmd.getOptionValue("o"));
			} else {
				OutputStream out = System.out;
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
