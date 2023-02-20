package common;

public class ExecuteContext {

    public static <T> T workWithExecuteStrategy(final ExecuteStrategy<T> executeStrategy) {
        T result = null;
        while (result == null) {
            result = catchException(executeStrategy, result);
        }
        return result;
    }

    private static <T> T catchException(final ExecuteStrategy<T> executeStrategy, T result) {
        try {
            result = executeStrategy.execute();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return result;
    }
}
