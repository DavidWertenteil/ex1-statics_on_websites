/**
 * @author DavidWertenteil
 */
abstract class Statistable {
    protected String name = null;
    protected String tag = null;

    /**
     * @return Name of desired statistics
     */
    public final String getName(){return name;}

    /**
     * Counts the appearance of a HTML tag
     * @param file - given HTML file as a string
     * @return Number of appearance of desired HTML tag
     */
    public int numberOfAppearance(String file){
        return file.length() - file.replace(tag, tag.substring(1)).length();
    }
}
