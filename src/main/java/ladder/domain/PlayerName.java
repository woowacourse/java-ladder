package ladder.domain;

import java.util.Objects;

public class PlayerName {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    
    private final String name;
    
    public PlayerName(String name) {
        validatePlayerName(name);
        this.name = name;
    }
    
    private void validatePlayerName(String name) {
        validateImpossibleName(name);
        validateNameLength(name);
    }
    
    private void validateImpossibleName(String name) {
        if ("all".equals(name)) {
            throw new IllegalArgumentException("참여자 이름으로 all은 입력할 수 없습니다.");
        }
    }
    
    private void validateNameLength(String name) {
        if (isOutOfNameLength(name)) {
            throw new IllegalArgumentException("각 이름 길이의 범위는 1~5 글자 입니다.");
        }
    }
    
    private boolean isOutOfNameLength(String name) {
        return name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH;
    }
    
    public int getLength() {
        return name.length();
    }
    
    public String getPlayerName() {
        return name;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerName that = (PlayerName) o;
        return Objects.equals(name, that.name);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
