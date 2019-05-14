import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {
    private static final List<String> SEPERATORS = Arrays.asList(",", ":");

    public static List<String> extractDelimiters(String input) {
        Matcher m = Pattern.compile("//(.*)\n(.*)").matcher(input);
        if (m.find()) {
            String delimiter = m.group(1);
            List<String> updatedSeperators = new ArrayList<>();
            updatedSeperators.add(delimiter);
            return updatedSeperators;
        }
        return SEPERATORS;
    }

    public static String extractExpression(String input) {
        Matcher m = Pattern.compile("//(.*)\n(.*)").matcher(input);
        if (m.find()) {
            return m.group(2);
        }
        return input;
    }
}
