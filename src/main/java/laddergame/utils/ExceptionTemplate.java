package laddergame.utils;

import java.util.function.Supplier;

public class ExceptionTemplate {
    private static final String MAX_REPEAT_EXCEPTION = "가능한 최대 반복 횟수를 초과하였습니다.";
    private static final int MAX_REPEAT_COUNT = 20;

    private ExceptionTemplate() {
    }

    public static <T> T repeatAndPrintCause(Supplier<T> supplier) {
        int repeatCount = 0;
        while (repeatCount++ != MAX_REPEAT_COUNT) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        throw new IllegalStateException(MAX_REPEAT_EXCEPTION);
    }
}
