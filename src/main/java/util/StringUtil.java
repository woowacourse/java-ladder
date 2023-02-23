package util;

public class StringUtil {

    private StringUtil() {}

    public static boolean isNullOrBlank(String str) {
        return str == null || str.isBlank();
    }
}
