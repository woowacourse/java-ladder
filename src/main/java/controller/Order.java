package controller;

import domain.vo.Name;

import java.util.List;

public class Order {
    private static final String END_ORDER = "end";
    private static final String ALL_VALUE = "all";
    private final String value;

    public Order(String value, List<Name> players) {
        validate(value, players);
        this.value = value;
    }

    private void validate(String value, List<Name> players) {
        if (isEnd(value) || isAll(value)) {
            return;
        }
        if (!players.contains(new Name(value))) {
            throw new NullPointerException("");
        }
    }

    private Boolean isEnd(String value) {
        return value.equals(END_ORDER);
    }

    public Boolean isEnd() {
        return value.equals(END_ORDER);
    }

    private Boolean isAll(String value) {
        return value.equals(ALL_VALUE);
    }

    public Boolean isAll() {
        return value.equals(ALL_VALUE);
    }

    public String getValue() {
        return this.value;
    }
}
