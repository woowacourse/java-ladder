package name;

public class Name {

    private final String name;

    public Name(final String name) {
        validateLengthOfName(name);
        this.name = name;
    }

    //TODO: 예외 메시지 작성
    private void validateLengthOfName(final String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
