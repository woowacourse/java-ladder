import java.util.List;
import java.util.regex.Pattern;

public class People {
    private static final String NAME_RULE = "[a-zA-Z0-9]{1,5}";

    public People(List<String> names) {
        for (String name : names) {
            if (name == null) {
                throw new IllegalArgumentException("이름은 5자 이내의 영숫자로 구성되어야 합니다.");
            }
            if (!name.matches(NAME_RULE)) {
                throw new IllegalArgumentException("이름은 5자 이내의 영숫자로 구성되어야 합니다.");
            }
        }
    }
}
