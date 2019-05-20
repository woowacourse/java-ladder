package laddergame.domain;

import laddergame.util.Validator;

public class Reward {
    private static final int MAX_NAME_LENGTH = 5;

    private String name;

    public Reward(String name) {
        Validator.checkBlankName(name);
        Validator.checkNameLength(name, MAX_NAME_LENGTH);
        this.name = name;
    }

    public String getName() {
        return name;
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
