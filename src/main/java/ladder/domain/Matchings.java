package ladder.domain;

import java.util.HashMap;

public class Matchings {
    public HashMap<Name, Result> getMatchings() {
        return matchings;
    }

    HashMap<Name, Result> matchings;

    public Matchings(HashMap<Name, Result> matchings) {
        this.matchings = matchings;
    }
}
