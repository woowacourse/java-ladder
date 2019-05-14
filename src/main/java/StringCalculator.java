import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int addAll(String string) {
        if (isBlank(string)) {
            return 0;
        }

        return sum(Numbers.toInts(getStrings(string)));
    }

    private static boolean isBlank(String string) {
        return string == null || string.isEmpty();
    }

    private static int sum(int[] numbers) {
        int sum = 0;

        for (int value : numbers) {
            sum += value;
        }

        return sum;
    }

    private static String[] getStrings(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);

            return tokens;
        }

        return text.split(",|:");
    }


}
