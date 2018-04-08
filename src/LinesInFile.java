/**
 * @author DavidWertenteil
 */
public class LinesInFile extends Statistable{
    LinesInFile() {
        super.name = "lines";
    }

    /**
     * Funcion counting number of lines in given HTML file
     * @param file - HTML file
     * @return Number of lines
     */
    public int numberOfAppearance(String file){
        int lines = 1;
        for (int i = 0; i < file.length(); ++i)
            if (file.charAt(i) == '\n')
                lines++;
        return lines;
    }
}
