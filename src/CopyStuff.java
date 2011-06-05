import java.io.FileInputStream;
import java.io.FileOutputStream;
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
    	InputStream in = null;	
        OutputStream out = null;
        //foobar comment
    	Options options = new Options();
    	options.addOption("i", true, "input file");
    	options.addOption("o", true, "output file");
    	CommandLineParser parser = new PosixParser();
    	CommandLine cmd = parser.parse(options, args);
         
        try {
        	if (cmd.hasOption("i")){
        		in = new FileInputStream(cmd.getOptionValue("i"));
        		System.out.println(in.getClass());
        	}
        	else{
        		in = System.in;
        	}
        	if (cmd.hasOption("o"))
        		out = new FileOutputStream(cmd.getOptionValue("o"));
        	else
        		out = System.out;
            
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
