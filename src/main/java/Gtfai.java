import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Gtfai {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static void main(String[] args) {
        String website = urlToString("https://www.bls.gov/tus/charts/chart9.txt");
        //System.out.println(website);

        // let's start counting

        int wordCount = 0;
        for (int i = 0; i < website.length() - 1; i++) {
            if (((website.charAt(i) == ' ') && (website.charAt(i + 1) != ' ')) && (!Character.isDigit(i - 1))) {
                wordCount++;
            }

        }
        System.out.print(wordCount);
    }
}
