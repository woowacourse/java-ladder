package ladder.model.player;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position;

    public Player(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    public void moveLeft() {
        this.position--;
    }

    public void moveRight() {
        this.position++;
    }

    private void validateName(String name) {
        if (isNameBlank(name)) {
            throw new IllegalArgumentException("빈 이름을 입력했습니다.");
        }
        if(isNameOverMaxLength(name)){
            throw new IllegalArgumentException("이름이 5자를 초과합니다.");
        }
    }

    private boolean isNameBlank(String name){
        return StringUtils.isBlank(name);
    }

    private boolean isNameOverMaxLength(String name){
        return name.length() > MAX_NAME_LENGTH;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
