package calculator;

public class Delimiter {
    public static String getFromString(String input) {
        String[] processedInput = input.split("\n");
        return processedInput[0].replace("//", "");
    }
}
