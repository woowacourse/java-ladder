package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PlayerNames {
    private static final String NAMES_INPUT_FORM = "([a-zA-Z]{1,5})(,[a-zA-Z]{1,5})*";
    
    private final List<String> names;
    
    public PlayerNames(String playerNames) {
        validate(playerNames);
        names = splitNames(playerNames);
    }
    
    private void validate(String playerNames) {
        validateNamesInputForm(playerNames);
        List<String> splitNames = splitNames(playerNames);
        validateRange(splitNames);
        validateDuplicateNames(splitNames);
    }
    
    private void validateRange(List<String> splitedNames) {
        if (splitedNames.size() < 2 || splitedNames.size() > 100) {
            throw new IllegalArgumentException("이름의 수가 2이상 100이하여야 합니다.");
        }
    }
    
    private void validateNamesInputForm(String names) {
        Matcher matcher = Pattern.compile(NAMES_INPUT_FORM).matcher(names);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("입력된 플레이어들의 이름 형식이 올바르지 않습니다.");
        }
    }
    
    private List<String> splitNames(String names) {
        return Arrays.stream(names.split(","))
                .collect(Collectors.toUnmodifiableList());
    }
    
    private void validateDuplicateNames(List<String> splitedNames) {
        if (deleteDuplicateNames(splitedNames) != splitedNames.size()) {
            throw new IllegalArgumentException("중복된 이름은 입력할 수 없습니다.");
        }
    }
    
    private int deleteDuplicateNames(List<String> splitedNames) {
        return (int) splitedNames.stream()
                .distinct()
                .count();
    }
    
    public int playerSize() {
        return names.size();
    }
    
    public int firstPlayerNameLength() {
        return names.get(0).length();
    }
    
    public List<String> getNames() {
        return names;
    }
}
