import java.io.*;


public class Runner {
    /**
     * @param file_url - The file with the URLs
     */
    public void run(String file_url) {
        String line;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            // FileReader reads text files in the default encoding.
            // Wrap FileReader in BufferedReader.
            bufferedReader = new BufferedReader(new FileReader(file_url));
            // Wrap FileWriter in BufferedWriter.
            bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

            if (!bufferedReader.ready()) {
                System.out.println("empty file");
            } else {
                ManageStatistics manageStatistics = new ManageStatistics();

                // Loop reading URLs and writing results
                while ((line = bufferedReader.readLine()) != null) {
                    // Send to url statistics and Save result in file
                    bufferedWriter.write(manageStatistics.getStatistics(line) + '\n');
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("missing file");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // Close files
        finally {
            try {
                bufferedReader.close();
                bufferedWriter.close();
            } catch (IOException ex) {
                System.out.println("cant close files");
            }
        }
    }
}
