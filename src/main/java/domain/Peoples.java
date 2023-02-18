package domain;

import java.util.List;

public class Peoples {

    private final List<People> peoples;

    public Peoples(List<People> peoples) {
        this.peoples = peoples;
    }

    public List<People> getPeoples() {
        return peoples;
    }
}
