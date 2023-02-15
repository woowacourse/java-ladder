public class User {
    private final String name;

    User(String name) {
        if (1 > name.length() || 5 < name.length()) {
            throw new IllegalArgumentException("이름은 1~5 글자 입니다.");
        }
        if (name.isBlank()){
            throw new IllegalArgumentException("이름은 공백으로만 이루어지면 안됩니다.");
        }
        this.name = name;
    }
}
