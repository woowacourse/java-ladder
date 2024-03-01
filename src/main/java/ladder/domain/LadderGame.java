package ladder.domain;

import ladder.view.Result;

import java.util.List;

public class LadderGame {
    private final People people;
    private final Compensation compensation;
    private final Ladder ladder;

    private LadderGame(People people, Compensation compensation, Ladder ladder) {
        this.people = people;
        this.compensation = compensation;
        this.ladder = ladder;
    }

    public Result getResult() {
        return Result.of(people, ladder, compensation);
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

    public static class LadderGameBuilder {
        private People people;
        private Compensation compensation;
        private Ladder ladder;

        public LadderGameBuilder names(List<String> names) {
            this.people = new People(names);
            return this;
        }

        public LadderGameBuilder compensations(List<String> compensations) {
            validateSize(compensations);
            this.compensation = new Compensation(compensations, people.length());
            return this;
        }

        public LadderGameBuilder height(int height) {
            this.ladder = new Ladder(height, people.length());
            return this;
        }

        public LadderGame build() {
            return new LadderGame(people, compensation, ladder);
        }

        private void validateSize(List<String> compensations) {
            if (people.length() != compensations.size()) {
                throw new IllegalArgumentException("보상 갯수와 사람 수가 일치하지 않습니다");
            }
        }
    }
}
