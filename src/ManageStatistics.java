/**
 * @author DavidWertenteil
 */

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.Vector;


public class ManageStatistics {
    // Vector of desired statistics
    private Vector<Statistable> desiredStatistics = new Vector();

    /**
     * The c-tor
     *  Add desired statistics to the vector
     */
    ManageStatistics() {
        desiredStatistics.add(new LinkTag());
        desiredStatistics.add(new ImgTag());
        desiredStatistics.add(new LinesInFile());
    }

    /**
     * @param line - line in file
     * @return The statistics of the desired URL
     */
    public String getStatistics(String line) {
        String content;
        URLConnection connection;
        String stat = line;
        try {
            connection = new URL(line).openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();

            // Take statistics from the HTML page
            for (int i = 0; i < desiredStatistics.size(); ++i) {
                stat += " " + desiredStatistics.elementAt(i).getName() + ":"
                        + desiredStatistics.elementAt(i).numberOfAppearance(content);
            }

        } catch (Exception ex) {
            // If there was a problem connecting or reading then write error
            stat += " error";
        }

        return stat;
    }
}
