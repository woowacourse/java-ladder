package com.woowacourse.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerList {
    private final List<String> names;

    public PlayerList(final List<String> names) {
        this.names = new ArrayList<>();
        this.names.addAll(names);
    }

    public int findPlayer(String name) {
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public int getSize() {
        return this.getNames().size();
    }

    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        names.addAll(this.names);
        return names;
    }

    public boolean isNotContain(String name) {
        return !names.contains(name);
    }
}
