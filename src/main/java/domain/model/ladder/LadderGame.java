package domain.model.ladder;

import domain.model.consequence.Consequences;
import domain.model.participant.People;

public class LadderGame {
    private final Ladder ladder;
    private final People people;
    private final Result result;

    public LadderGame(Ladder ladder, People people, Consequences consequences) {
        this.ladder = ladder;
        this.people = people;

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
