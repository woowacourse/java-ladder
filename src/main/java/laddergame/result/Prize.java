package laddergame.result;

import laddergame.vo.Name;

public class Prize {
    private final Name name;

    public Prize(Name name) {
        this.name = name;
    }

    public String getName() {
        return name.getName();
    }
}
