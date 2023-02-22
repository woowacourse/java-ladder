package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerNames {
    private static final int MIN_PLAYER_NUMBER = 2;
    private static final int MAX_PLAYER_NUMBER = 100;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int FIRST_INDEX = 0;
    
    private final List<String> names;
    
    public PlayerNames(String playerNames) {
        List<String> splitNames = splitNames(playerNames);
        validate(splitNames);
        names = splitNames;
    }
    
    private List<String> splitNames(String names) {
        return Arrays.stream(names.split(","))
                .collect(Collectors.toUnmodifiableList());
    }
    
    private void validate(List<String> splitNames) {
        validateNameLength(splitNames);
        validateRange(splitNames);
        validateDuplicateNames(splitNames);
    }
    
    private void validateNameLength(List<String> splitNames) {
        if (isOutOfNameLength(splitNames)) {
            throw new IllegalArgumentException("각 이름 길이의 범위는 1~5 글자 입니다.");
        };
    }
    
    private boolean isOutOfNameLength(List<String> splitNames) {
        return splitNames.stream()
                .map(String::length)
                .anyMatch(nameLength -> nameLength > MAX_NAME_LENGTH || nameLength < MIN_NAME_LENGTH);
    }
    
    private void validateRange(List<String> splitedNames) {
        if (splitedNames.size() < MIN_PLAYER_NUMBER || splitedNames.size() > MAX_PLAYER_NUMBER) {
            throw new IllegalArgumentException("이름의 수가 2이상 100이하여야 합니다.");
        }
    }
    
    private void validateDuplicateNames(List<String> splitedNames) {
        if (getDistinctNamesNumber(splitedNames) != splitedNames.size()) {
            throw new IllegalArgumentException("중복된 이름은 입력할 수 없습니다.");
        }
    }
    
    private int getDistinctNamesNumber(List<String> splitedNames) {
        return (int) splitedNames.stream()
                .distinct()
                .count();
    }
    
    public int playerSize() {
        return names.size();
    }
    
    public int getFirstPlayerNameLength() {
        return names.get(FIRST_INDEX).length();
    }
    
    public int getPlayerIndex(String player) {
        return names.indexOf(player);
    }
    
    public String findByName(String playerName) {
        if (playerName.equals("all")) {
            return playerName;
        }
        
        return names.stream()
                .filter(name -> name.equals(playerName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 플레이어입니다."));
    }
    
    public List<String> getNames() {
        return names;
    }
}
