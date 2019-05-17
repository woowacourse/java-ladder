package com.woowacourse.ladder.domain;



import com.woowacourse.ladder.InputValidator;

import java.util.List;
public class PlayerList {
    private final List<String> names;

    public PlayerList(final List<String> names) {
        if (!InputValidator.isValidNamesInput(names)) {
            throw new IllegalArgumentException();
        }
        this.names = names;
    }

    public int findPlayer(String name) {
        for (int i = 0; i < names.size(); i++) {
            if(names.get(i).equals(name)){
                return i;
            }
        }
        return -1;
    }

    public int getSize(){
        return this.getNames().size();
    }

    public List<String> getNames() {
        return names;
    }
}
