
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Runner {
    Runner(){
    }
    public void run(String url_file){
        String line;
        try{
            // FileReader reads text files in the default encoding.
            // Wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(new FileReader(url_file));

            // Wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

            // Loop reading URLs and writing results
            while((line = bufferedReader.readLine()) != null) {
                // Send to url statistics
                String content;
                URLConnection connection;
                try {
                    connection = new URL(line).openConnection();
                    Scanner scanner = new Scanner(connection.getInputStream());
                    scanner.useDelimiter("\\Z");
                    content = scanner.next();

                    // Take statistics from the HTML page
                    // Each statistic should be in it's own class and have an Interface connect between them.
                    int img = content.length() - content.replace("<img", "img").length();
                    int links = content.length() - content.replace("<link", "link").length();
                    int lines = 0;
                    for (int i = 0; i < content.length(); ++i)
                        if (content.charAt(i) == '\n')
                            lines++;

                    // Save result in file
                    bufferedWriter.write(line + " links:" + links + " images:" + img + " lines:" + lines + '\n');

                }catch ( Exception ex ) {
                    System.out.println("Unable to open or read HTML file with " + line + " URL");
                    // If there was a problem connecting or reading then write error
                    bufferedWriter.write(line + " error" + '\n');

                }
            }

            // Close files
            bufferedReader.close();
            bufferedWriter.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file ");
            System.exit(0);

        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
