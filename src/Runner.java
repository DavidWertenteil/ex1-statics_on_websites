import java.io.*;

/**
 * @author DavidWertenteil
 */

public class Runner {
    /**
     * @param file_url - The file with the URLs
     * @exception RuntimeException if file is empty
     */
    public void run(String file_url){
        String line;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            // Wrap FileReader in BufferedReader.
            bufferedReader = new BufferedReader(new FileReader(file_url));
            // Wrap FileWriter in BufferedWriter.
            bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

            if (!bufferedReader.ready()) {
                throw new RuntimeException("empty file");
            } else {
                ManageStatistics manageStatistics = new ManageStatistics();

                // Loop reading URLs and writing results
                while ((line = bufferedReader.readLine()) != null) {
                    // Send to url statistics and Save result in file
                    bufferedWriter.write(manageStatistics.getStatistics(line) + '\n');
                }
            }
        } catch (RuntimeException ex){
            System.out.println(ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.out.println("missing file");
            System.exit(0);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(0);
        }
        // Close files
        finally {
            try {
                bufferedReader.close();
                bufferedWriter.close();
            }
            catch (IOException ex) {
                System.out.println("cant close files");
            }
        }
    }
}
