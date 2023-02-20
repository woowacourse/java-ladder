package domain;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
public class People {

    private final String name;

    private static final int MAX_NAME_LENGTH = 5;

    public People(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private static void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.length() == 0) {
            throw new IllegalArgumentException("이름은 1~" + MAX_NAME_LENGTH + "글자여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
