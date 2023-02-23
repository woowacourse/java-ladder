package domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private final static String ALL = "all";

    private final People people;
    private final Prizes prizes;
    private final Ladder ladder;

    public LadderGame(People people, Prizes prizes, Ladder ladder) {
        this.people = people;
        this.prizes = prizes;
        this.ladder = ladder;
    }

    public void start() {
        for (Person person : people.getPeople()) {
            move(person);
        }
    }

    private void move(Person person) {
        for (int heightIndex = 0; heightIndex < ladder.getHeight(); heightIndex++) {
            int currentPosition = person.getPosition().getValue();
            ShiftType shiftType = ladder.findShiftType(currentPosition, heightIndex);
            person.move(shiftType);
        }
    }

    public LadderResults searchResult(String personName) {
        if (ALL.equals(personName)) {
            return searchAllResult();
        }
        return searchOne(personName);
    }

    private LadderResults searchAllResult() {
        List<Person> people = this.people.getPeople();
        List<LadderResult> ladderResults = people.stream()
            .map((p) -> new LadderResult(p, prizes.getPrize(p.getPosition().getValue())))
            .collect(Collectors.toUnmodifiableList());
        return new LadderResults(ladderResults);
    }

    private LadderResults searchOne(String personName) {
        Person person = people.searchByName(personName);
        int personIndex = person.getPosition()
            .getValue();
        String prize = prizes.getPrize(personIndex);
        List<LadderResult> ladderResults = List.of(new LadderResult(person, prize));
        return new LadderResults(ladderResults);
    }
}
