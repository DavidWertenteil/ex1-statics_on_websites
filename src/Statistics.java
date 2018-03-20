public class Statistics {
    public static void main(String[] args) {
        if(args.length == 0){
            System.err.println("No file found");
            System.exit(0);
        }
        Runner run = new Runner();
        run.run(args[0]);

    }
}
