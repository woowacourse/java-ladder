public class User {
    private String name;

    public static void validateNameLength(String name) {
        if (name.length() <= 0 || name.length() > 5) {
            throw new IllegalArgumentException("");
        }
    }
}
