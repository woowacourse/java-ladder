package ladder.domain;

import ladder.view.Result;

public class LadderGame {
    private final People people;
    private final Ladder ladder;
    private final Compensation compensation;
    private final Result result;

    public LadderGame(People people, Ladder ladder, Compensation compensation) {
        this.people = people;
        this.ladder = ladder;
        this.compensation = compensation;
        this.result = Result.of(people, ladder, compensation);
    }

    public People getPeople() {
        return people;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Compensation getCompensation() {
        return compensation;
    }

    public Result getResult() {
        return result;
    }
}
