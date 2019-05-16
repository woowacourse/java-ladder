package domain;

import java.util.*;

public class User {
    private final String name;
    private int position;

    public User(final String name, final int lineNum) {
        validateNameBlank(name);
        validateNameLength(name);
        this.name = name;
        this.position = lineNum;
    }

    private void validateNameBlank(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("생성자를 생성할 수 없습니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw  new IllegalArgumentException("이름이 5자 초과입니다.");
        }
    }

    public boolean canMove(Floor floor) {
        List<Boolean> stairs = floor.getStairs();

        return checkFirstLine(stairs) ||
                checkLastLine(stairs.size(), stairs) ||
                checkLeft(stairs) ||
                checkRight(stairs);
    }

    private boolean checkLastLine(int size, List<Boolean> stairs) {
        if (position == size) {
            checkLeft(stairs);
            return true;
        }
        return false;
    }

    private boolean checkFirstLine(List<Boolean> stairs) {
        if (position == 0) {
            checkRight(stairs);
            return true;
        }
        return false;
    }

    private boolean checkLeft(List<Boolean> stairs) {
        if (stairs.get(position - 1)) {
            moveLeft();
            return true;
        }
        return false;
    }

    private boolean checkRight(List<Boolean> stairs) {
        if (stairs.get(position)) {
            moveRight();
            return true;
        }
        return false;
    }

    private void moveLeft() {
        position--;
    }

    private void moveRight() {
        position++;
    }
    
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
