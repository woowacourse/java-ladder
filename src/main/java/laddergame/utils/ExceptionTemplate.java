package laddergame.utils;

import java.util.function.Supplier;

public class ExceptionTemplate {

    private ExceptionTemplate() {
    }

    public static <T> T repeat(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (RuntimeException ignored) {
                /* IGNORED */
            }
        }
    }
    public static <T> T repeatAndPrintCause(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
