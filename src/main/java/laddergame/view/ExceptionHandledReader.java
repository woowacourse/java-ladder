package laddergame.view;

import java.util.function.Supplier;
import static java.lang.System.*;

public class ExceptionHandledReader {
    private ExceptionHandledReader() {
    }

    public static <T> T readUntilNoError(Supplier<T> supplier) {
        T readObj = null;
        while (readObj == null) {
            readObj = readOnce(supplier);
        }
        return readObj;
    }

    private static <T> T readOnce(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            out.println(e.getMessage());
        }
        return null;
    }

}
