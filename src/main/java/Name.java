public class Name {
    private final String name;

    public Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException("이름은 1~5자 사이여야 합니다.");
        }
    }
}
