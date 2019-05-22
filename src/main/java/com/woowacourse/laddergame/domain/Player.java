package com.woowacourse.laddergame.domain;

import java.util.Objects;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String ILLEGAL_NAME = "all";

    private final String name;

    public Player(String name) {
        checkValidationName(name);
        this.name = name;
    }

    private void checkValidationName(String name) {
        checkNull(name);
        checkEmpty(name);
        checkLength(name);
        checkIllegalName(name);
    }

    private void checkNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("null을 입력할 수 없습니다");
        }
    }

    private void checkEmpty(String name)  {
        if (name.contains(" ")) {
            throw new IllegalArgumentException("이름에 공백이 있으면 안됩니다");
        }
        if (name.trim().length() == 0) {
            throw new IllegalArgumentException("공백을 입력할 수 없습니다");
        }
    }

    private void checkLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자 까지 가능합니다");
        }
    }

    private void checkIllegalName(String name) {
        if (name.equals(ILLEGAL_NAME)) {
            throw new IllegalArgumentException("all은 player 이름으로 입력할 수 없습니다");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%6.6s", name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return Objects.equals(getName(), player.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
