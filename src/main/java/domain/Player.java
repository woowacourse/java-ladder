package domain;

public class Player {

    public static final int NAME_MAX_LENGTH = 5;
    private static final String BLANK_NAME_ERROR = "[ERROR] 빈 문자열 입니다.";
    private static final String NAME_LENGTH_ERROR = "[ERROR] 이름 길이는 5자를 넘길 수 없습니다.";

    private final String name;
    private final int position;

    public Player(String name, int position){
        this.name = name;
        this.position = position;
        validateNameLength(name);
        validateNameBlank(name);
    }

    public String getName() {
        return name;
    }

    private void validateNameBlank(String name) {
        if (name.isBlank()){
            throw new IllegalArgumentException(BLANK_NAME_ERROR);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

}
