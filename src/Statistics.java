/**
 * @author DavidWertenteil
 */
public class Statistics {
    /**
     * @param args - Name of file containing the URLs
     * @exception  RuntimeException if there is no file in command line
     */
    public static void main(String[] args) {
        try {
            if (args.length == 0) {
               throw new RuntimeException("No file found");
            }
        }catch(RuntimeException ex){
            System.err.println(ex.getMessage());
            System.exit(0);
        }
        Runner run = new Runner();
        run.run(args[0]);
    }
}
