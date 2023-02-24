package util;

public class ExceptionTemplate {
    public static <T> T reInputIfException(ExceptionStrategy<T> strategy) {
        T input = null;
        while (input == null) {
            input = readInput(strategy);
        }
        return input;
    }

    private static <T> T readInput(ExceptionStrategy<T> strategy) {
        try {
            return strategy.run();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }
}
