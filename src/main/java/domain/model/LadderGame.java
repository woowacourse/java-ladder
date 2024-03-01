package domain.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {
    private final Ladder ladder;
    private final People people;
    private final Consequences consequences;
    private final Result result;

    public LadderGame(Ladder ladder, People people, Consequences consequences) {
        this.ladder = ladder;
        this.people = people;
        this.consequences = consequences;

        result = new Result(people, consequences);
    }

    public void play() {
        for (int positionOfPerson = 0; positionOfPerson < people.getNumberOfParticipants(); positionOfPerson++) {
            int positionOfConsequence = ladder.goToConsequence(positionOfPerson, 0);
            result.make(positionOfPerson, positionOfConsequence);
        }
    }

    public Result giveResult() {
        return result;
    }
}
