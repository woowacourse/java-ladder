public class Player {
    private final String name;

    public Player(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private  void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 사람 이름은 최대 5글자 입니다.");
        }
    }
}
