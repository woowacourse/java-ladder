package laddergame.domain;

import laddergame.util.Validator;

import java.util.Objects;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;

    private String name;

    public Player(String name) {
        Validator.checkBlankName(name);
        Validator.checkNameLength(name, MAX_NAME_LENGTH);
        this.name = name;
    }

    public String getName() {
        return name;
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
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        StringBuilder nameView = new StringBuilder("       ");
        int nameStart = 3 - name.length() / 2;
        int nameEnd = nameStart + name.length();
        nameView.replace(nameStart, nameEnd, name);
        return nameView.toString();
    }
}
